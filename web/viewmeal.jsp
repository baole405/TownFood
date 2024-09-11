<%-- 
    Document   : viewmeal
    Created on : Jul 15, 2024, 12:20:38 AM
    Author     : baolee
--%>
<%@page import="dto.MealIngre"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MealIngreDAO"%>
<%@page import="dto.MealCategory"%>
<%@page import="dao.MealCategoryDAO"%>
<%@page import="dto.Meal"%>
<%@page import="dao.MealDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="/WEB-INF/tlds/mytags" prefix="m" %>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<style>
    .viewmeal {
        margin-top: 150px;
        margin-bottom: 60px;
    }
    .container_descrip {
        height: auto;
        background-color:#A3C7DD59;
        padding: 5px;
        border-radius: 20px;
        box-shadow: 0 0 10px rgba(188, 36, 36, 0.1);
        overflow: auto;
    }
    .container_img {
        height: auto;
        background-color: rgb(223, 140, 140);
        padding: 10px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(188, 36, 36, 0.1);
    }
    .img_product {
        width: 100%;
        height: 100%;
        border-radius: 8px;
    }
    .more {
        display: none;
    }
    .btn-more {
        border: none;
        background-color: transparent;
        font-size: 14px;
    }
    .txtB {
        font-weight: bold;
    }
    .txtRecipe {
        font-style: italic;
        text-align: justify;
    }
</style>
<body>
    <% 
        String id = (String) request.getAttribute("id");
        if (id != null) {
    %>
    <m:ViewMeal id="<%=id%>"></m:ViewMeal>
    <% } %>
</body>

<%@include file="footer.jsp" %>
