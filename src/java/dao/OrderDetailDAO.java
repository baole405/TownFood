/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.OrderDetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.MyLib;

/**
 *
 * @author trung
 */
public class OrderDetailDAO {

    public int create(OrderDetail od) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "INSERT INTO [dbo].[OrderDetail] ([Id_order], [Id_meal], [Quantity] VALUES (?, ?, ?)";

                pst = cn.prepareStatement(sql);
                pst.setInt(1, od.getId());
                pst.setInt(2, od.getIdMeal());
                pst.setInt(3, od.getQuantity());
                rs = pst.executeUpdate();
                cn.commit(); // Commit the transaction 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            if (cn != null) {
                try {
                    cn.rollback(); // Rollback the transaction if there is an error
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.setAutoCommit(true);
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }

    public ArrayList<OrderDetail> getOrders(int id) {
        ArrayList<OrderDetail> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "SELECT [Id_meal], [Quantity] FROM [dbo].[OrderDetail] Where  [Id_order] = ?";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int idMeal = rs.getInt("Id_meal");
                    int quantity = rs.getInt("Quantity");
                    list.add(new OrderDetail(id, idMeal, quantity));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }
}
