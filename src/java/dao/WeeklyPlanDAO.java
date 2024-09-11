/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Meal;
import dto.WeeklyPlan;
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
public class WeeklyPlanDAO {

    public int create(WeeklyPlan plan) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "Insert into [dbo].[WeeklyPlan] ([Id_plan], [Period], [Id_meal]) values (?, ?, ?)";
                pst = cn.prepareStatement(sql);
                pst.setDate(1, plan.getId());
                pst.setString(2, plan.getPeriod());
                pst.setInt(3, plan.getIdMeal());

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
   public ArrayList<WeeklyPlan> read() {
        ArrayList<WeeklyPlan> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "Select [Id_plan], [Period], [Id_meal] from [dbo].[WeeklyPlan]";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    Date id = rs.getDate("Id-plan");
                    String period = rs.getString("Period");
                    int idMeal = rs.getInt("Id_meal");
                    
                    WeeklyPlan plan = new WeeklyPlan(id, period, idMeal);
                    list.add(plan);
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
    
    public int update(WeeklyPlan plan) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "Update [dbo].[WeeklyPlan] Set [Id_meal] = ? where [Id_plan] = ? And [Period] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, plan.getIdMeal());
                pst.setDate(2, plan.getId());
                pst.setString(3, plan.getPeriod());

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
        public int delete(WeeklyPlan plan) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "Delete from [dbo].[WeeklyPlan] Where [Id_plan] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, plan.getIdMeal());


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
}
