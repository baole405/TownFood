<%-- 
    Document   : orderhistory
    Created on : Jul 16, 2024, 12:56:59 AM
    Author     : trung
--%>

<%@page import="dto.Meal"%>
<%@page import="dao.MealDAO"%>
<%@page import="dto.OrderDetail"%>
<%@page import="dao.OrderDetailDAO"%>
<%@page import="dto.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<%@include file="header.jsp" %>

<style>
    .container-cart-header {
        background-color: #335577;
        height: 50px;
        display: flex;
        justify-content: center;
        align-items: center;
        border-radius: 20px 20px 0px 0px;
        border-top: 2px solid black;
        border-right: 2px solid black;
        border-left: 2px solid black;
    }

    .txttitle {
        color: #CCCCCC;
        font-size: 20px;
        font-weight: bold;
        margin: 0;
    }

    .txtheader {
        color: #333333;
        font-size: 16px;
        font-weight: bold;
        margin: 0;
    }
</style>

<body>
    <div class="container mt-5 p-3">
        <div class="container-cart-header">
            <h2 class="txttitle">Order History</h2>
        </div>
        <div class="row no-gutters">
            <div style="width: 100%;">
                <div class="product-details  p-3" style="background-color: #A3C7DD59; border: 2px solid black;">
                    <div class="row">
                        <div class="col-md-2 txtheader">Số thứ tự</div>
                        <div class="col-md-2 txtheader">Mã đơn</div>
                        <div class="col-md-2 txtheader">Ngày</div>
                        <div class="col-md-2 txtheader">Giá</div>
                        <div class="col-md-2 txtheader">Tiến trình</div>
                    </div>
                    <hr style="border: 1px solid black;">
                    <%
                        ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("HistoryList");
                        if (list != null) {
                    %>
                    <% int i = 1;%>

                    <c:forEach var="order" items="<%= list%>">
                        <div class="row">
                            <div class="col-md-2 "><%=i++%></div>
                            <div class="col-md-2 ">${order.id}</div>
                            <div class="col-md-2 ">${order.date}</div>
                            <div class="col-md-2 ">${order.price}</div>
                            <div class="col-md-2 ">${order.process}</div>
                        </div>   
                    </c:forEach>
                    <% }%>
                </div>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp" %>

