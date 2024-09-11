<%-- 
    Document   : home
    Created on : Jun 28, 2024, 1:11:52 PM
    Author     : baolee
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.List"%>
<%@page import="dto.Meal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<style>
    .card-text {
        text-align: center;
    }
    body{
        background-color: #a3c7dd59;
    }
    .listmeal img:hover{
        transform: scale(1.1)
    }
</style>
<fmt:setLocale value="vi_VN"/>
<div id="carouselBanner" class="carousel slide " data-mdb-ride="carousel" data-mdb-carousel-init>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="img/34714452 (1).jpg" class="d-block w-100" alt=""/>
        </div>
        <div class="carousel-item">
            <img src="img/34714452 (2).jpg" class="d-block w-100" alt=""/>
        </div>
        <div class="carousel-item">
            <img src="img/34714452 (3).jpg" class="d-block w-100" alt=""/>
        </div>
    </div>
    <button
        class="carousel-control-prev"
        type="button"
        tabindex="0"
        data-mdb-slide="prev"
        data-mdb-target="#carouselBanner"
        >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    </button>
    <button
        class="carousel-control-next"
        type="button"
        tabindex="0"
        data-mdb-slide="next"
        data-mdb-target="#carouselBanner"
        >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
    </button>
</div>
<%
    List<Meal> list1 = (List<Meal>) request.getAttribute("list1");
%>    
<h3 style="text-align: center;" class="my-5">
    <i class="fas fa-utensils" style="font-size: 30px; margin-bottom: 5px;"></i>
    Đồ mặn 
</h3>
<section class="listmeal">

    <div class="wrapper wrapper-list carousel-1">
        <i id="left" class="fa-solid fa-angle-left"></i>
        <ul class="carousel carousel-list">
            <c:forEach var="meal1" items="<%=list1%>">
                <li class="card card-meal">
                    <a href="MainController?action=ViewMeal&id=${meal1.id}" >
                        <div class="img"><img style="border-radius: 15px; margin-top: 20px; transition: transform 0.5s ease;" src="${meal1.address}" alt="img"></div>
                        <div class="card-text">
                            <h2>${meal1.name}</h2>
                            <span><strong><fmt:formatNumber value="${meal1.price}" type="currency"/></strong></span>
                        </div>
                    </a>
                </li>
            </c:forEach>
        </ul>
        <i id="right" class="fa-solid fa-angle-right"></i>
    </div>
</section>

<%
    List<Meal> list2 = (List<Meal>) request.getAttribute("list2");
%>    
<h3 style="text-align: center;" class="my-5">
    <i class="fas fa-carrot" style="font-size: 30px; margin-bottom: 5px;"></i>
    Đồ chay
</h3>
<section class="listmeal">

    <div class="wrapper wrapper-list carousel-2">
        <i id="left" class="fa-solid fa-angle-left"></i>
        <ul class="carousel carousel-list">
            <c:forEach var="meal2" items="<%=list2%>">
                <li class="card card-meal">
                    <a href="MainController?action=ViewMeal&id=${meal2.id}" >
                        <div class="img"><img style="border-radius: 15px; margin-top: 20px; transition: transform 0.5s ease;" src="${meal2.address}" alt="img"></div>
                        <div class="card-text">
                            <h2>${meal2.name}</h2>
                            <span><strong><fmt:formatNumber value="${meal2.price}" type="currency"/></strong></span>
                        </div>
                    </a>
                </li>
            </c:forEach>
        </ul>
        <i id="right" class="fa-solid fa-angle-right"></i>
    </div>
</section>

<%
    List<Meal> list3 = (List<Meal>) request.getAttribute("list3");
%>    
<h3 style="text-align: center;" class="my-5">
    <i class="fas fa-wine-bottle" style="font-size: 30px; margin-bottom: 5px;"></i>
    Đồ uống 
</h3>
<section class="listmeal">

    <div class="wrapper wrapper-list carousel-3">
        <i id="left" class="fa-solid fa-angle-left"></i>
        <ul class="carousel carousel-list">
            <c:forEach var="meal3" items="<%=list3%>">
                <li class="card card-meal">
                    <a href="MainController?action=ViewMeal&id=${meal3.id}" >
                        <div class="img"><img style="border-radius: 15px; margin-top: 20px; transition: transform 0.5s ease;" src="${meal3.address}" alt="img"></div>
                        <div class="card-text">
                            <h2>${meal3.name}</h2>
                            <span><strong><fmt:formatNumber value="${meal3.price}" type="currency"/></strong></span>
                        </div>
                    </a>
                </li>
            </c:forEach>
        </ul>
        <i id="right" class="fa-solid fa-angle-right"></i>
    </div>
</section>
<div class="row container-fluid mt-5" style="margin-bottom: 100px">
    <div class="col-md-4 text-center">
        <i class="fas fa-box fa-3x"></i>
        <h4>Giao hàng tận nơi</h4>
    </div>

    <div class="col-md-4  text-center">
        <i class="fas fa-hand-holding-heart fa-3x"></i>
        <h4>Đảm bảo vệ sinh an toàn thực phẩm</h4>
    </div>

    <div class="col-md-4  text-center">
        <i class="fas fa-face-grin-hearts fa-3x"></i>
        <h4>Ngon tuyệt vời !!</h4>
    </div>
</div>





<%@include file="footer.jsp" %>
