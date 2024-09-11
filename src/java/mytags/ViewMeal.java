/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytags;

import dao.MealCategoryDAO;
import dao.MealDAO;
import dao.MealIngreDAO;
import dto.Meal;
import dto.MealCategory;
import dto.MealIngre;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author trung
 */
public class ViewMeal extends SimpleTagSupport {

    private String id;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            MealDAO d = new MealDAO();
            Meal meal = d.read(Integer.parseInt(id));
            MealCategoryDAO md = new MealCategoryDAO();
            MealIngreDAO mi = new MealIngreDAO();
            MealCategory mcate = md.read(Integer.parseInt(meal.getMcate()));
            ArrayList<MealIngre> list = (ArrayList<MealIngre>) mi.readIngre(id);
            Locale locale = new Locale("vi", "VN");
            NumberFormat format = NumberFormat.getCurrencyInstance(locale);
            out.println("<div class=\"container viewmeal\">");
            out.println("<div class=\"row\">");
            out.println("<div class=\"col-md-6 container_descrip\">");
            out.println("<h1 class=\"m-4\" style=\"text-align: center;\">" + meal.getName() + "</h1>");
            out.println("<p class=\"m-2\"><span class=\"txtB\">Type:</span> " + mcate.getName() + "</p>");
            out.println("<p class=\"m-2 txtB\">Ingredient:</p>");
            out.println("<ul>");
            for (MealIngre ingre : list) {
                out.println("<li>" + ingre.getName() + " : " + ingre.getAmount() + "</li>");
            }
            String addToCartUrl = String.format("MainController?action=addtocart&mealid=%d",  meal.getId());
            out.println("</ul>");
            out.println("<p class=\"m-2 txtB\">Recipe:</p>");
            out.println("<p class=\"txtRecipe m-3\">" + meal.getRecipe() + "</p>");
            out.println("<p class=\"m-2\"><span class=\"txtB\">Price:</span> " + format.format(meal.getPrice()) + "</p>");
            out.println("<a href=\"" + addToCartUrl + "\" class=\"btn btn-primary\" data-mdb-ripple-init>Thêm vào giỏ hàng</a>");
            out.println("</div>");
            out.println("<div class=\"col-md-6 container_img\" style=\"background-color: #335577;\">");
            out.println("<img class=\"img_product\" src=\"" + meal.getAddress() + "\">");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (Exception ex) {
            throw new JspException("Error in ViewMeal tag", ex);
        }
    }

    public void setId(String id) {
        this.id = id;
    }

}
