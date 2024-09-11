/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Ingredient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.MyLib;

/**
 *
 * @author trung
 */
public class IngredientDAO implements CRUD<Ingredient>{

    @Override
    public int create(Ingredient ing) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "Insert [dbo].[Ingredient] ([Id_ingredient], [Id_category], [Name], [Quantity] , [Status]) values (?,?,?,?,?)";

                pst = cn.prepareStatement(sql);
                pst.setInt(1, ing.getId());
                pst.setString(2, ing.getIcate());
                pst.setString(3, ing.getName());
                pst.setInt(4, ing.getQuantity());
                pst.setInt(5, ing.getStatus());
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

    @Override
    public Ingredient read(int id) {
        Ingredient ing = null;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "Select [Id_category], [Name], [Quantity], [Status] From [dbo].[Ingredient] Where [Id_ingredient] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        String icate = rs.getString("Id_category");
                        String name = rs.getString("Name");
                        int quantity = rs.getInt("Quantity");
                        int status = rs.getInt("Status");

                        ing = new Ingredient(id, icate, name, quantity, status);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ing;
    }

    @Override
    public int update(Ingredient ing) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "Update [dbo].[Ingredient] Set [Id_category] = ?, [Name] = ?, [Quantity] = ?, [Status] = ? Where [Id_ingredient] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, ing.getIcate());
                pst.setString(2, ing.getName());
                pst.setInt(3, ing.getStatus());
                pst.setInt(4, ing.getQuantity());
                pst.setInt(5, ing.getId());
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

    @Override
    public int delete(Ingredient ing) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);

                String sql = "Update [dbo].[Ingredient] Set [Status] = ? Where [Id_ingredient] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, 0);
                pst.setInt(2, ing.getId());
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

    public ArrayList<Ingredient> getIngredients() {
        ArrayList<Ingredient> list = new ArrayList<>();
        ResultSet rs = null;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);

                String sql = "Select [Id_ingredient], [Id_category], [Name], [Quantity], [Status] From [dbo].[Ingredient]";
                Statement st = cn.createStatement();
                rs = st.executeQuery(sql);
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("Id_ingredient");
                        String icate = rs.getString("Id_category");
                        String name = rs.getString("Name");
                        int quantity = rs.getInt("Quantity");
                        int status = rs.getInt("Status");

                        Ingredient ing = new Ingredient(id, icate, name, quantity, status);
                        list.add(ing);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return list;
    }

    public Ingredient getIngredient(String name) {
        Ingredient ing = null;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "Select [Id_ingredient], [Id_category], [Quantity], [Status] From [dbo].[Ingredient] Where [Name] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("Id_ingredient");
                        String icate = rs.getString("Id_category");
                        int quantity = rs.getInt("Quantity");
                        int status = rs.getInt("Status");

                        ing = new Ingredient(id, icate, name, quantity, status);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
        return ing;
    }

    public boolean checkIngredient(Ingredient ing) {
        return ing.getStatus() == 1;
    }

    public int active(Ingredient ing) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);

                String sql = "Update [dbo].[Ingredient] Set [Status] = ? Where [Id_ingredient] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, 1);
                pst.setInt(2, ing.getId());
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

}
