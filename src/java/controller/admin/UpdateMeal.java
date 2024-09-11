/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dao.MealDAO;
import dto.Meal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author baolee
 */
public class UpdateMeal extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String id = request.getParameter("mealID");
            MealDAO d = new MealDAO();
            Meal meal = d.read(Integer.parseInt(id));
            if (meal != null) {
                String mcate = request.getParameter("mcate");
                String name = request.getParameter("name");
                String recipe = request.getParameter("recipe");
                String price = request.getParameter("price");
                String status = request.getParameter("status");
                System.out.println("Tai servlet"+name);
                int flag = d.update(new Meal(Integer.parseInt(id), mcate, name, recipe, Float.parseFloat(price), Integer.parseInt(status)));
                if (flag != 0) {
                    request.setAttribute("message", "Cập nhật thành công!");
                    request.setAttribute("messageType", "success");
                } else {
                    request.setAttribute("message", "Cập nhật thất bại!");
                    request.setAttribute("messageType", "erro");
                }
                request.getRequestDispatcher("GetMealServlet").forward(request, response);
            } else {
                request.getRequestDispatcher("GetMealServlet").forward(request, response);
            }
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
