<%-- 
    Document   : menu
    Created on : Jul 3, 2024, 10:15:53 AM
    Author     : baolee
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.List"%>
<%@page import="dto.Meal"%>
<%@page import="dao.MealDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<section id="menu" class="p-5">
    <div class="container">
        <h2 class="mb-4 text-center">Our Menu</h2>
        <div class="menu-container row">
            <!-- Sidebar -->
<!--            <div class="sidebar col-md-3">
                <h5>Filters</h5>
                 Search Bar 
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Search for dishes..." aria-label="Search for dishes" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">Search</button>
                </div>
                 Filter by Type 
                <h6>Type</h6>
                <select class="form-select mb-3" aria-label="Filter by type">
                    <option selected>All Types</option>
                    <option value="1">Appetizers</option>
                    <option value="2">Main Courses</option>
                    <option value="3">Desserts</option>
                </select>
                 Filter by Price 
                <h6>Price</h6>
                <div class="row mb-3">
                    <div class="col">
                        <input type="number" class="form-control" placeholder="Min price" aria-label="Min price">
                    </div>
                    <div class="col">
                        <input type="number" class="form-control" placeholder="Max price" aria-label="Max price">
                    </div>
                </div>
                <button class="btn btn-primary btn-block">Apply Filters</button>
            </div>-->
            <!-- Sidebar -->
            <% MealDAO d = new MealDAO();
                List<Meal> list = d.getMealByName("ga");
            %>

            <!-- Menu Content -->
            <div class="menu-content col-md-9">
                <div class="row"  id="testsearch">
                    <c:forEach var="meal" items="<%=list%>">
                        <div class="col-md-4 menu-item">
                            <div class="card ">
                                <a href="MainController?action=ViewMeal&id=${meal.id}" >
                                    <img src="${meal.address}" alt="img">
                                    <a href="#"></a>
                                    <div class="card-body">
                                        <h5 class="card-title">${meal.name}</h5>
                                        <fmt:setLocale value="vi_VN"/>
                                        <p class="card-text"><strong> <fmt:formatNumber value="${meal.price}" type="currency"/></strong></p>                                       
                                        <a href="MainController?action=addtocart&mealid=${meal.id}" class="btn btn-primary" data-mdb-ripple-init>Thêm vào giỏ hàng</a>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <!-- Menu Content -->
        </div>
    </div>
</section>
<!-- Menu Section -->
<%@include file="footer.jsp" %>
