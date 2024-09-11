
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
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
public class AccountDAO implements CRUD<Account> {

    /**
     * This function is used to create an account in the database
     *
     * @param acc account from server to push to the database
     * @return an integer value representing the result of the operation
     */
    @Override
    public int create(Account acc) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "Insert [dbo].[Account] ([Username], [Password],[Role] ,[Status]) values (?,?,?,?)";

                pst = cn.prepareStatement(sql);
                pst.setString(1, acc.getName());
                pst.setString(2, acc.getPassword());
                pst.setString(3, "Client");
                pst.setInt(4, 1);
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
     * This function is used to read an account from the database by id
     *
     * @param id the id of the account to read
     * @return the account object
     */
    @Override
    public Account read(int id) {
        Account acc = null;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "Select [Username], [Password],[Role], [Status]\n"
                        + "From [dbo].[Account] \n"
                        + "Where [Id_acc] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        String userName = rs.getString("Username");
                        String password = rs.getString("Password");
                        String role = rs.getString("Role");
                        int status = rs.getInt("Status");

                        acc = new Account(id, userName, password,role, status);
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
        return acc;
    }

    /**
     * This function is used to update an account in the database
     *
     * @param acc the account object with updated information
     * @return an integer value representing the result of the operation
     */
    @Override
    public int update(Account acc) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "Update [dbo].[Account]\n"
                        + "Set [Username] = ?, [Password] = ?,[Role] = ?, [Status] = ?\n"
                        + "Where [Id_acc] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, acc.getName());
                pst.setString(2, acc.getPassword());
                pst.setString(3, acc.getRole());
                pst.setInt(4, acc.getStatus());
                pst.setInt(5, acc.getId());
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
     * This function is used to delete (deactivate) an account in the database
     *
     * @param acc the account object to delete (deactivate)
     * @return an integer value representing the result of the operation
     */
    @Override
    public int delete(Account acc) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);

                String sql = "Update [dbo].[Account]\n"
                        + "Set [Status] = ?\n"
                        + "Where [Id_acc] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, 0);
                pst.setInt(2, acc.getId());
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
     * This function is used to get a list of all accounts in the database
     *
     * @return an ArrayList of account objects
     */
    public ArrayList<Account> getAccounts() {
        ArrayList<Account> list = new ArrayList<>();
        ResultSet rs = null;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);

                String sql = "Select [Id_acc], [Username], [Password],[Role], [Status]\n"
                        + "From [dbo].[Account] ";
                Statement st = cn.createStatement();
                rs = st.executeQuery(sql);
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("Id_acc");
                        String name = rs.getString("Username");
                        String password = rs.getString("Password");
                        String role = rs.getString("Role");
                        int status = rs.getInt("Status");

                        Account acc = new Account(id, name, password, role, status);
                        list.add(acc);
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

    /**
     * This function is used to get an account by username from the database
     *
     * @param userName the username of the account to retrieve
     * @return the account object
     */
    public Account getAccount(String userName) {
        Account acc = null;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "Select [Id_acc], [Password], [Role], [Status]\n"
                        + "From [dbo].[Account] \n"
                        + "Where [Username] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, userName);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("Id_acc");
                        String password = rs.getString("Password");
                        String role = rs.getString("Role");
                        int status = rs.getInt("Status");

                        acc = new Account(id, userName, password, role, status);
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
        return acc;
    }

    /**
     * This function is used to get an account from the database
     *
     * @param userName username of the account to retrieve
     * @param password password of the account to retrieve
     * @return the account object
     */
    public Account getAccount(String userName, String password) {
        Account acc = null;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                System.out.println("test Connect");
                String sql = "Select [Id_acc], [Role], [Status]\n"
                        + "From [dbo].[Account] \n"
                        + "Where [Username] = ?  and [Password] = ? ";
                pst = cn.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("Id_acc");
                        String role = rs.getString("Role");
                        int status = rs.getInt("Status");

                        acc = new Account(id, userName, password, role, status);
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
        return acc;
    }

    /**
     * This function is used to check that an account is active or not
     *
     * @param acc account need to check
     * @return a boolean value (1 if it active)
     */
    public boolean checkAccount(Account acc) {
        return acc.getStatus() == 1;
    }
        public int active(Account acc) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);

                String sql = "Update [dbo].[Account]\n"
                        + "Set [Status] = ?\n"
                        + "Where [Id_acc] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, 1);
                pst.setInt(2, acc.getId());
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
