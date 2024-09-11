/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.client;

import dao.MealDAO;
import dto.Account;
import dto.Meal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trung
 */
public class AddToCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /* TODO output your page here. You may use following sample code. */
        MealDAO d = new MealDAO();
        HttpSession session = request.getSession();

        String id = request.getParameter("mealid");
        Meal meal = d.read(Integer.parseInt(id.trim()));
        String url = request.getHeader("referer");
        Account acc = (Account) session.getAttribute("LoginAccount");
        if (acc != null) {
            if (url == null || url.isEmpty()) {
                url = "menu.jsp";
            } else {
                String action = url.substring(url.lastIndexOf("/") + 1);

                if (action.equals("TestURL") || action.equals("TestURLServlet")) {
                    url = "menu.jsp";
                } else {
                    url = action;
                }
            }
            if (meal != null) {
                HashMap<Meal, Integer> cart = (HashMap<Meal, Integer>) session.getAttribute("cart");
                if (cart == null) {
                    cart = new HashMap<>();
                }
                if (cart.containsKey(meal)) {
                    cart.put(meal, cart.get(meal) + 1);
                } else {
                    cart.put(meal, 1);
                }
                session.setAttribute("cart", cart);
                response.sendRedirect(url);
            }
        } else {
            url = "login.jsp";
            response.sendRedirect(url);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
