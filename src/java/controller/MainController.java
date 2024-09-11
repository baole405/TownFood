/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trung
 */
public class MainController extends HttpServlet implements IConstant {

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
        String action = request.getParameter("action");
        String url = HOME_PAGE;
        if (action == null) {
            url = HOME_PAGE;
        } else if (LOGIN.equalsIgnoreCase(action)) {
            url = LOGIN_SERVLET;
        } else if (LOGOUT.equalsIgnoreCase(action)) {
            url = LOGOUT_SERVLET;
        } else if (SEARCH.equalsIgnoreCase(action)) {
            url = SEARCH_SERVLET;
        } else if (CHANGESTATUS.equalsIgnoreCase(action)) {
            url = CHANGESTATUS_SERVLET;
        } else if (GETINGREDIENT.equalsIgnoreCase(action)) {
            url = GETINGREDIENT_SERVLET;
        } else if (GETMEAL.equalsIgnoreCase(action)) {
            url = GETMEAL_SERVLET;
        } else if (GETUSER.equalsIgnoreCase(action)) {
            url = GETUSER_SERVLET;
        } else if (UPDATEINGRE.equalsIgnoreCase(action)) {
            url = UPDATEINGRE_SERVLET;
        } else if (UPDATEMEAL.equalsIgnoreCase(action)) {
            url = UPDATEMEAL_SERVLET;
        } else if (ADDTOCART.equalsIgnoreCase(action)) {
            url = ADDTOCART_SERVLET;
        } else if (CHECKOUT.equalsIgnoreCase(action)) {
            url = CHECKOUT_SERVLET;
        } else if (EDITCART.equalsIgnoreCase(action)) {
            url = EDITCART_SERVLET;
        } else if (GETALLMEALS.equalsIgnoreCase(action)) {
            url = GETALLMEALS_SERVLET;
        } else if (HOME.equalsIgnoreCase(action)) {
            url = HOME_SERVLET;
        } else if (PROFILE.equalsIgnoreCase(action)) {
            url = PROFILE_SERVLET;
        } else if (REGISTER.equalsIgnoreCase(action)) {
            url = REGISTER_SERVLET;
        } else if (UPDATEUSER.equalsIgnoreCase(action)) {
            url = UPDATEUSER_SERVLET;
        } else if (USERDETAIL.equalsIgnoreCase(action)) {
            url = USERDETAIL_SERVLET;
        } else if (PERSONALPLAN.equalsIgnoreCase(action)) {
            url = PERSONALPLAN_SERVLET;
        } else if (UPDATEPERSONAL.equalsIgnoreCase(action)) {
            url = UPDATEPERSONAL_SERVLET;
        } else if (UPDATEWEEKLYPLAN.equalsIgnoreCase(action)) {
            url = UPDATEWEEKLYPLAN_SERVLET;
        } else if (WEEKLYPLAN.equalsIgnoreCase(action)) {
            url = WEEKLYPLAN_SERVLET;
        } else if (VIEWMEAL.equalsIgnoreCase(action)) {
            url = VIEWMEAL_SERVLET;
        } else if (GETORDER.equalsIgnoreCase(action)) {
            url = GETORDER_SERVLET;
        } else if (SEARCHORDER.equalsIgnoreCase(action)) {
            url = SEARCHORDER_SERVLET;
        } else if (ORDERHISTORY.equalsIgnoreCase(action)) {
            url = ORDERHISTORY_SERVLET;
        }
        request.getRequestDispatcher(url).forward(request, response);
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
