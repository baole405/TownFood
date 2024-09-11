/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Meal;
import java.util.ArrayList;
import dto.Meal;
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
public class MealDAO implements CRUD<Meal> {

    /**
     * This function is used to create a meal in the database
     *
     * @param meal meal object to push to the database
     * @return an integer value representing the result of the operation
     */
    @Override
    public int create(Meal meal) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "INSERT INTO [dbo].[Meal] ([Id_meal], [Id_category], [Name], [Recipe], [Price], [Status]) VALUES (?, ?, ?, ?, ?, ?, ?)";

                pst = cn.prepareStatement(sql);
                pst.setInt(1, meal.getId());
                pst.setString(2, meal.getMcate());
                pst.setString(3, meal.getName());
                pst.setString(5, meal.getRecipe());
                pst.setFloat(6, meal.getPrice());
                pst.setInt(7, meal.getStatus());
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

    /**
     * This function is used to read a meal from the database by id
     *
     * @param id the id of the meal to read
     * @return the meal object
     */
    @Override
    public Meal read(int id) {
        Meal meal = null;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "SELECT M.[Name] ,M.[Id_category], M.[Recipe], M.[Price], M.[Status] , I.[Address]\n"
                        + "FROM [dbo].[Meal] M\n"
                        + "INNER JOIN [dbo].[MealImg] I\n"
                        + "ON M.[Id_meal] = I.[Id_meal]\n"
                        + "WHERE M.[Id_meal] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        String mcate = rs.getString("Id_category");
                        String name = rs.getString("Name");
                        String recipe = rs.getString("Recipe");
                        float price = rs.getFloat("Price");
                        int status = rs.getInt("Status");
                        String address = rs.getString("Address");
                        meal = new Meal(id, mcate, name, recipe, price, status, address);
                        
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.setAutoCommit(true);
                    cn.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return meal;
    }

    /**
     * This function is used to update a meal in the database
     *
     * @param meal the meal object with updated information
     * @return an integer value representing the result of the operation
     */
    @Override
    public int update(Meal meal) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "UPDATE [dbo].[Meal] SET [Id_category] = ?, [Name] = ?, [Recipe] = ?, [Price] = ?, [Status] = ? WHERE [Id_meal] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, meal.getMcate());
                pst.setNString(2, meal.getName());
                pst.setNString(3, meal.getRecipe());
                pst.setFloat(4, meal.getPrice());
                pst.setInt(5, meal.getStatus());
                pst.setInt(6, meal.getId());
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
                    cn.setAutoCommit(true); // Return to default AutoCommit state
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }

    /**
     * This function is used to delete (deactivate) a meal in the database
     *
     * @param meal the meal object to delete (deactivate)
     * @return an integer value representing the result of the operation
     */
    @Override
    public int delete(Meal meal) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);

                String sql = "UPDATE [dbo].[Meal] SET [Status] = ? WHERE [Id_meal] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, 0);
                pst.setInt(2, meal.getId());
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
                    cn.setAutoCommit(true); // Return to default AutoCommit state
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }

    /**
     * This function is used to get all meals from the database
     *
     * @return a list of meal objects
     */
    public ArrayList<Meal> getMeals() {
        ArrayList<Meal> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "SELECT M.[Id_meal], M.[Id_category], M.[Name], M.[Recipe], M.[Price], M.[Status] , I.[Address]\n"
                        + "FROM [dbo].[Meal] M\n"
                        + "INNER JOIN [dbo].[MealImg] I\n"
                        + "ON M.[Id_meal] = I.[Id_meal]"
                        + "Where [Status] = 1";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id_meal");
                    String mcate = rs.getString("Id_category");
                    String name = rs.getString("Name");
                    String recipe = rs.getString("Recipe");
                    float price = rs.getFloat("Price");
                    int status = rs.getInt("Status");
                    String address = rs.getString("Address");
                    list.add(new Meal(id, mcate, name, recipe, price, status, address));
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

    /**
     * This function is used to get a meal from the database by name
     *
     * @param name the name of the meal to get
     * @return the meal object
     */
    public ArrayList<Meal> getMealByName(String name) {
        ArrayList<Meal> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "SELECT M.[Id_meal],M.[Name] ,M.[Id_category], M.[Recipe], M.[Price], M.[Status] , I.[Address]\n"
                        + "FROM [dbo].[Meal] M\n"
                        + "INNER JOIN [dbo].[MealImg] I\n"
                        + "ON M.[Id_meal] = I.[Id_meal]\n"
                        + "WHERE [Name] like  ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");

                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id_meal");
                    String mcate = rs.getString("Id_category");
                    String mealname = rs.getString("Name");
                    String recipe = rs.getString("Recipe");
                    float price = rs.getFloat("Price");
                    int status = rs.getInt("Status");
                    String address = rs.getString("Address");
                    list.add(new Meal(id, mcate, mealname, recipe, price, status, address));
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

    /**
     * This function is used to check if a meal is active
     *
     * @param meal the meal object to check
     * @return true if the meal is active, false otherwise
     */
    public boolean checkMeal(Meal meal) {
        return meal.getStatus() == 1;
    }

    /**
     * This function is used to get all meals from the database by category
     *
     * @return a list of meal objects
     */
    public ArrayList<Meal> getMealsByCate(int[] cates) {
        ArrayList<Meal> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "SELECT M.[Id_meal],M.[Name] ,M.[Id_category], M.[Recipe], M.[Price], M.[Status] , I.[Address]\n"
                        + "FROM [dbo].[Meal] M\n"
                        + "INNER JOIN [dbo].[MealImg] I\n"
                        + "ON M.[Id_meal] = I.[Id_meal]\n"
                        + "WHERE  [Status] = 1 AND [Id_category] IN (";
                for (int i = 0; i < cates.length; i++) {
                    sql += "?";
                    if (i < cates.length - 1) {
                        sql += ", ";
                    }
                }
                sql += ")";
                pst = cn.prepareStatement(sql);
                for (int i = 0; i < cates.length; i++) {
                    pst.setInt(i + 1, cates[i]);
                }
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id_meal");
                    String mcate = rs.getString("Id_category");
                    String name = rs.getString("Name");
                    String recipe = rs.getString("Recipe");
                    float price = rs.getFloat("Price");
                    int status = rs.getInt("Status");
                    String address = rs.getString("Address");
                    list.add(new Meal(id, mcate, name, recipe, price, status, address));
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
