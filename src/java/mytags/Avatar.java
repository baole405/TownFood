/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytags;

import dto.Account;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author trung
 */
public class Avatar extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            PageContext pageContext = (PageContext) getJspContext();
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("LoginAccount");

            if (acc != null) {
                // Shopping cart icon
                out.println("<a class=\"text-reset me-3 fa-lg\" href=\"viewcart.jsp\">");
                out.println("<i class=\"fas fa-shopping-cart\"></i>");
                out.println("</a>");

                out.println("<div class=\"dropdown\">");
                out.println("<a data-mdb-dropdown-init class=\"dropdown-toggle d-flex align-items-center hidden-arrow\" href=\"#\" id=\"navbarDropdownMenuAvatar\" role=\"button\" aria-expanded=\"false\">");
                out.println("<img src=\"https://mdbcdn.b-cdn.net/img/new/avatars/2.webp\" class=\"rounded-circle\" height=\"50\" alt=\"Avatar\" loading=\"lazy\" />");
                out.println("</a>");
                out.println("<ul class=\"dropdown-menu dropdown-menu-end\" aria-labelledby=\"navbarDropdownMenuAvatar\">");
                out.println("<li>");
                out.println("<a class=\"dropdown-item\" href=\"MainController?action=Profile\">My profile</a>");
                out.println("</li>");
                out.println("<li>");
                out.println("<a class=\"dropdown-item\" href=\"MainController?action=OrderHistory\">Order History</a>");
                out.println("</li>");
                out.println("<li>");
                out.println("<a class=\"dropdown-item\" href=\"MainController?action=Logout\">Logout</a>");
                out.println("</li>");
                out.println("</ul>");
                out.println("</div>");
            } else {
                out.println("<div class=\"dropdown\">");
                out.println("<a data-mdb-dropdown-init style=\"color: #616161\" class=\"dropdown-toggle d-flex align-items-center hidden-arrow\" href=\"#\" id=\"navbarDropdownMenuAvatar\" role=\"button\" aria-expanded=\"false\">");
                out.println("<i class=\"fas fa-circle-user fa-2x\" loading:lazy ></i>");
                out.println("</a>");
                out.println("<ul class=\"dropdown-menu dropdown-menu-end\" aria-labelledby=\"navbarDropdownMenuAvatar\">");
                out.println("<li>");
                out.println("<a class=\"dropdown-item\" href=\"register.jsp\">Register</a>");
                out.println("</li>");
                out.println("<li>");
                out.println("<a class=\"dropdown-item\" href=\"login.jsp\">Login</a>");
                out.println("</li>");
                out.println("</ul>");
                out.println("</div>");
            }

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Avatar tag", ex);
        }
    }

}
