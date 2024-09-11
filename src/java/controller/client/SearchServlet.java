/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.client;

import dao.MealDAO;
import dto.Meal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trung
 */
public class SearchServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        MealDAO d = new MealDAO();
        List<Meal> list = d.getMealByName(txtSearch);
        PrintWriter out = response.getWriter();
        for (Meal meal : list) {
            out.println("                        <div class=\"col-md-4 menu-item\">\n"
                    + "                            <div class=\"card \">\n"
                    + "                                <img src=\""+meal.getAddress()+"\" alt=\"img\">\n"
                    + "                                <a href=\"#\"></a>\n"
                    + "                                <div class=\"card-body\">\n"
                    + "                                    <h5 class=\"card-title\">"+meal.getName()+"</h5>\n"
                    + "                                    <p class=\"card-text\"><strong>"+meal.getPrice()+"</strong></p>\n"
                    + "                                    <a href=\"#!\" class=\"btn btn-primary\" data-mdb-ripple-init>Thêm vào giỏ hàng</a>\n"
                    + "                                </div>\n"
                    + "                            </div>\n"
                    + "                        </div>");
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
