/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AccountDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mylib.MyLib;

/**
 *
 * @author trung
 */
public class AccountDetailDAO implements CRUD<AccountDetail>{
        /**
     * This function is used to create an account detail in the database
     *
     * @param accDetail account detail to push to the database
     * @return an integer value representing the result of the operation
     */
    @Override
    public int create(AccountDetail accDetail) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "INSERT INTO [dbo].[AccountDetail] ([Id_acc], [FullName], [Gender], [PhoneNumber], [Address], [Email], [Img]) VALUES (?, ?, ?, ?, ?, ?, ?)";
                
                pst = cn.prepareStatement(sql);
                pst.setInt(1, accDetail.getId());
                pst.setNString(2, accDetail.getFullName());
                pst.setNString(3, accDetail.getGender());
                pst.setString(4, accDetail.getPhoneNumber());
                pst.setNString(5, accDetail.getAddress());
                pst.setString(6, accDetail.getEmail());
                pst.setString(7, accDetail.getImg());
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
     * This function is used to read an account detail from the database by id
     *
     * @param id the id of the account detail to read
     * @return the account detail object
     */
    @Override
    public AccountDetail read(int id) {
        AccountDetail accDetail = null;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "SELECT [FullName], [Gender], [PhoneNumber], [Address], [Email], [Img] FROM [dbo].[AccountDetail] WHERE [Id_acc] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        String fullName = rs.getString("FullName");
                        String gender = rs.getString("Gender");
                        String phoneNumber = rs.getString("PhoneNumber");
                        String address = rs.getString("Address");
                        String email = rs.getString("Email");
                        String img = rs.getString("Img");

                        accDetail = new AccountDetail(id, fullName, gender, phoneNumber, address, email, img);
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
        return accDetail;
    }

    /**
     * This function is used to update an account detail in the database
     *
     * @param accDetail the account detail object with updated information
     * @return an integer value representing the result of the operation
     */
    @Override
    public int update(AccountDetail accDetail) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "UPDATE [dbo].[AccountDetail] SET [FullName] = ?, [Gender] = ?, [PhoneNumber] = ?, [Address] = ?, [Email] = ?, [Img] = ? WHERE [Id_acc] = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, accDetail.getFullName());
                pst.setString(2, accDetail.getGender());
                pst.setString(3, accDetail.getPhoneNumber());
                pst.setString(4, accDetail.getAddress());
                pst.setString(5, accDetail.getEmail());
                pst.setString(6, accDetail.getImg());
                pst.setInt(7, accDetail.getId());
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
     * This function is used to delete (deactivate) an account detail in the database
     *
     * @param accDetail the account detail object to delete (deactivate)
     * @return an integer value representing the result of the operation
     */
    @Override
    public int delete(AccountDetail accDetail) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);

                String sql = "UPDATE [dbo].[AccountDetail] SET [Status] = ? WHERE [Id] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, 0);
                pst.setInt(2, accDetail.getId());
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
