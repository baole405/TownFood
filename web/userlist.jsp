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
<div class="content w-100">
    <h1>Danh sách tài khoản</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên tài khoản</th>
                <th>Mật khẩu</th>
                <th>Chức vụ</th>
                <th>Trạng thái</th>
                <th>Vi phạm</th>
                <th>Thay trạng thái</th>
            </tr>
        </thead>
        <tbody>

            <c:forEach var="acc" items="${requestScope.ListAccount}">
                <tr>
                    <td>${acc.id}</td>
                    <td>${acc.name}</td>
                    <td>${acc.password}</td>
                    <td>${acc.role}</td>
                    <td>${acc.status}</td>
                    <td>NA</td>
                    <td class="action-links">
                        <c:url value="ChangeStatusServlet" var="statusUrl">
                            <c:param name="accId" value="${acc.id}" />
                        </c:url>
                        <a href="${statusUrl}">Sửa</a>
                    </td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
</div>
</div>
<script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.umd.min.js"
></script>
</body>
</html>
