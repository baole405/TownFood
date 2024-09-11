/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.MealIngre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.MyLib;

/**
 *
 * @author trung
 */
public class MealIngreDAO {

    public ArrayList<MealIngre> readIngre(String id) {
        ArrayList<MealIngre> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "	Select MI.Id_meal, MI.Id_ingredient, I.Name, MI.Amount \n"
                        + "	From [dbo].[MealIngredient] MI\n"
                        + "	Left join [dbo].[Ingredient] I\n"
                        + "	On MI.Id_ingredient = I.Id_ingredient\n"
                        + "	Where [Id_meal] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(id));
                rs = pst.executeQuery();
                while (rs.next()) {
                    int idMeal = rs.getInt("Id_ingredient");
                    String name = rs.getString("Name");
                    int amount = rs.getInt("amount");
                    list.add(new MealIngre(idMeal, idMeal, name, amount));
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
