<%-- 
    Document   : userlist
    Created on : Jul 6, 2024, 11:59:50 AM
    Author     : trung
--%>
<%@page import="java.util.List"%>
<%@page import="dto.Account"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="dashboard.jsp" %>
<link href="css/list.css" rel="stylesheet" >
<div class="content w-100" style="margin-top: 70px">
    <div style="display: flex; justify-content: space-around">
        <form action="MainController" method="post">
            Email: 
            <input type="text" name="email">
            <button type="submit" name="action" value="SearchOrder" >Search</button>
        </form>
        <form action="MainController" method="post">
            Phone number:  
            <input type="text" name="phone">
            <button type="submit" name="action" value="SearchOrder" >Search</button>
        </form>
    </div>

    <c:if test="${not empty requestScope.OrderSearch}">
        <h1>Danh sách đơn hàng</h1>
        <table>
            <thead>
                <tr>
                    <th>ID Đơn hàng</th>
                    <th>ID tài khoản</th>
                    <th>Ngày</th>
                    <th>Tiến trình</th>
                    <th>Trạng thái</th>
                    <th>Giá</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${requestScope.OrderSearch}">
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.idAcc}</td>
                        <td>${order.date}</td>
                        <td>${order.process}</td>
                        <td>${order.status}</td>
                        <td>${order.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.umd.min.js"
></script>
</body>
</html>
