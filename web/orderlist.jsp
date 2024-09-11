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
    <h1>Danh sách đơn hàng</h1>
    <table>
        <thead>
            <tr>
                <th>ID Đơn hàng</th>
                <th>ID tài khoản</th>
                <th>
                    <div style="display: flex; align-items: center; justify-content: center;">
                        Ngày
                        <form id="toggleForm" action="MainController" method="post" style="display: inline;">
                            <input type="hidden" name="orderby" id="orderbyInput" value="DESC">
                            <button type="button" class="toggle-button" onclick="toggleOrder()">
                                <i class="fas fa-angle-down"></i>
                            </button>
                            <input type="hidden" name="action" value="GetOrder">
                        </form>
                    </div>
                </th>
                <th>Tiến trình</th>
                <th>Trạng thái</th>
                <th>Giá</th>
            </tr>
        </thead>
        <tbody>

            <c:forEach var="order" items="${requestScope.ListOrder}">
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
</div>
</div>
<script>
        // Load trạng thái từ localStorage khi trang được tải lại
        window.onload = function() {
            const orderby = localStorage.getItem('orderby') || 'DESC';
            const orderbyInput = document.getElementById('orderbyInput');
            const buttonIcon = document.querySelector('.toggle-button .fas');

            orderbyInput.value = orderby;
            if (orderby === 'ASC') {
                buttonIcon.classList.remove('fa-angle-down');
                buttonIcon.classList.add('fa-angle-up');
            } else {
                buttonIcon.classList.remove('fa-angle-up');
                buttonIcon.classList.add('fa-angle-down');
            }
        };

        function toggleOrder() {
            const orderbyInput = document.getElementById('orderbyInput');
            const buttonIcon = document.querySelector('.toggle-button .fas');

            if (orderbyInput.value === 'DESC') {
                orderbyInput.value = 'ASC';
                buttonIcon.classList.remove('fa-angle-down');
                buttonIcon.classList.add('fa-angle-up');
            } else {
                orderbyInput.value = 'DESC';
                buttonIcon.classList.remove('fa-angle-up');
                buttonIcon.classList.add('fa-angle-down');
            }

            // Lưu trạng thái vào localStorage
            localStorage.setItem('orderby', orderbyInput.value);

            // Gửi form
            document.getElementById('toggleForm').submit();
        }
</script>   
<script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.umd.min.js"
></script>
</body>
</html>
