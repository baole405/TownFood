/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.MyLib;

public class OrderDAO implements CRUD<Order> {

    /**
     * This function is used to create an order in the database
     *
     * @param order order object to push to the database
     * @return an integer value representing the result of the operation
     */
    @Override
    public int create(Order order) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "INSERT INTO [dbo].[Order] ([Id_acc], [Date], [Process], [Status], [Price]) VALUES (?, ?, ?, ?, ?)";

                pst = cn.prepareStatement(sql);
                pst.setInt(1, order.getIdAcc());
                pst.setDate(2, new Date(System.currentTimeMillis()));
                pst.setString(3, order.getProcess());
                pst.setInt(4, order.getStatus());
                pst.setFloat(5, order.getPrice());
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
     * This function is used to read an order from the database by id
     *
     * @param id the id of the order to read
     * @return the order object
     */
    @Override
    public Order read(int id) {
        Order order = null;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "SELECT [Id_acc], [Date], [Process], [Status], [Price] FROM [dbo].[Order] WHERE [Id_order] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int idAcc = rs.getInt("Id_acc");
                        Date date = rs.getDate("Date");
                        String process = rs.getString("Process");
                        int status = rs.getInt("Status");
                        float price = rs.getFloat("Price");

                        order = new Order(id, idAcc, date, process, status, price);
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
        return order;
    }

    /**
     * This function is used to update an order in the database
     *
     * @param order the order object with updated information
     * @return an integer value representing the result of the operation
     */
    @Override
    public int update(Order order) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "UPDATE [dbo].[Order] SET [Id_acc] = ?, [Date] = ?, [Process] = ?, [Status] = ?, [Price] = ? WHERE [Id_order] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, order.getIdAcc());
                pst.setDate(2, new Date(order.getDate().getTime()));
                pst.setString(3, order.getProcess());
                pst.setInt(4, order.getStatus());
                pst.setFloat(5, order.getPrice());
                pst.setInt(6, order.getId());
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
     * This function is used to delete (deactivate) an order in the database
     *
     * @param order the order object to delete (deactivate)
     * @return an integer value representing the result of the operation
     */
    @Override
    public int delete(Order order) {
        int rs = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);

                String sql = "UPDATE [dbo].[Order] SET [Status] = ? WHERE [Id_order] = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, 0);
                pst.setInt(2, order.getId());
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
     * This function is used to get all orders from the database
     *
     * @return a list of order objects
     */
    public ArrayList<Order> getOrders() {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "SELECT [Id_order], [Id_acc], [Date], [Process], [Status], [Price] FROM [dbo].[Order]";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id_order");
                    int idAcc = rs.getInt("Id_acc");
                    Date date = rs.getDate("Date");
                    String process = rs.getString("Process");
                    int status = rs.getInt("Status");
                    float price = rs.getFloat("Price");
                    list.add(new Order(id, idAcc, date, process, status, price));
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
     * This function is used to get an order from the database by account id
     *
     * @param idAcc the id of the account to get the order
     * @return the order object
     */
    public Order getOrderByAccountId(int idAcc) {
        Order order = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "SELECT [Id_order], [Date], [Process], [Status], [Price] FROM [dbo].[Order] WHERE [Id_acc] = ? ORDER BY [Date] DESC";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, idAcc);
                rs = pst.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("Id_order");
                    Date date = rs.getDate("Date");
                    String process = rs.getString("Process");
                    int status = rs.getInt("Status");
                    float price = rs.getFloat("Price");
                    order = new Order(id, idAcc, date, process, status, price);
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
        return order;
    }
        public ArrayList<Order> getOrdersByAccountId(int idAcc) {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "SELECT [Id_order], [Date], [Process], [Status], [Price] FROM [dbo].[Order] WHERE [Id_acc] = ? ORDER BY [Date] DESC";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, idAcc);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id_order");
                    Date date = rs.getDate("Date");
                    String process = rs.getString("Process");
                    int status = rs.getInt("Status");
                    float price = rs.getFloat("Price");
                    Order order = new Order(id, idAcc, date, process, status, price);
                    list.add(order);
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
     * This function is used to check if an order is active
     *
     * @param order the order object to check
     * @return true if the order is active, false otherwise
     */
    public boolean checkOrder(Order order) {
        return order.getStatus() == 1;
    }

    public ArrayList<Order> getOrdersASC() {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "SELECT [Id_order], [Id_acc], [Date], [Process], [Status], [Price] FROM [dbo].[Order] ORDER BY [Date] ASC";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id_order");
                    int idAcc = rs.getInt("Id_acc");
                    Date date = rs.getDate("Date");
                    String process = rs.getString("Process");
                    int status = rs.getInt("Status");
                    float price = rs.getFloat("Price");
                    list.add(new Order(id, idAcc, date, process, status, price));
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

    public ArrayList<Order> getOrdersDECS() {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "SELECT [Id_order], [Id_acc], [Date], [Process], [Status], [Price] FROM [dbo].[Order] ORDER BY [Date] DESC";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id_order");
                    int idAcc = rs.getInt("Id_acc");
                    Date date = rs.getDate("Date");
                    String process = rs.getString("Process");
                    int status = rs.getInt("Status");
                    float price = rs.getFloat("Price");
                    list.add(new Order(id, idAcc, date, process, status, price));
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

    public ArrayList<Order> getOrdersPhone(String phone) {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "SELECT O.[Id_acc], O.[Id_order], O.[Date], O.[Process], O.[Status], O.[Price]\n"
                        + "FROM [dbo].[AccountDetail] A\n"
                        + "INNER JOIN [dbo].[Order] O\n"
                        + "ON A.[Id_acc] = O.[Id_acc]\n"
                        + "Where A.[PhoneNumber] like ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%"+phone+"%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id_order");
                    int idAcc = rs.getInt("Id_acc");
                    Date date = rs.getDate("Date");
                    String process = rs.getString("Process");
                    int status = rs.getInt("Status");
                    float price = rs.getFloat("Price");
                    list.add(new Order(id, idAcc, date, process, status, price));
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
    public ArrayList<Order> getOrdersEmail(String email) {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "SELECT O.[Id_acc], O.[Id_order], O.[Date], O.[Process], O.[Status], O.[Price]\n"
                        + "FROM [dbo].[AccountDetail] A\n"
                        + "INNER JOIN [dbo].[Order] O\n"
                        + "ON A.[Id_acc] = O.[Id_acc]\n"
                        + "Where A.[Email] like ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%"+email+"%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Id_order");
                    int idAcc = rs.getInt("Id_acc");
                    Date date = rs.getDate("Date");
                    String process = rs.getString("Process");
                    int status = rs.getInt("Status");
                    float price = rs.getFloat("Price");
                    list.add(new Order(id, idAcc, date, process, status, price));
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
