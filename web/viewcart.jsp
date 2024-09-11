<%-- 
    Document   : viewcart
    Created on : Jul 15, 2024, 11:50:26 AM
    Author     : trung
--%>
<%@page import="dto.OrderDetail"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<style>
    .viewcart {
        min-height: 500px
    }
    td{

        padding: 0;
    }
    .btn-check {
        display: none;
    }

    .btn {
        display: inline-block;
        width: 100px; /* Adjust as needed */
        text-align: center;
        padding: 10px;
        border: 1px solid #ccc;
        cursor: pointer;
    }

    .btn-check:checked + .btn {
        background-color: #007bff;
        color: white;
    }
</style>
<style>
    .order-summary {
        max-width: 400px;
        margin: auto;
        border: 1px solid #ddd;
        border-radius: 8px;
        padding: 20px;
        background-color: #f8f9fa;
    }
    .summary-title {
        font-size: 1.25rem;
        font-weight: bold;
        margin-bottom: 20px;
    }
    .summary-item {
        display: flex;
        justify-content: space-between;
        margin-bottom: 10px;
    }
    .summary-total {
        display: flex;
        justify-content: space-between;
        font-size: 1.25rem;
        font-weight: bold;
        margin-top: 20px;
        padding-top: 10px;
        border-top: 1px solid #ddd;
    }
    .checkout-button {
        display: block;
        width: 100%;
        background-color: #4CAF50;
        color: white;
        text-align: center;
        padding: 15px;
        font-size: 1rem;
        text-decoration: none;
        border-radius: 8px;
        margin-top: 20px;
    }
    .coupon-code {
        color: green;
        text-decoration: none;
    }
</style>
<fmt:setLocale value="vi_VN"/>
<p class="card-text"><strong> <fmt:formatNumber value="${meal.price}" type="currency"/></strong></p>                                       

<section class="viewcart container text-center" style="margin-top:150px">
    <c:set var="no" value="0"></c:set>
        <table class="table">
            <thead>
                <tr>
                    <td >Số thứ tự</td>
                    <td >Loại</td>
                    <td >Tên</td>
                    <td >Ảnh</td>
                    <td >Giá</td>
                    <td >Số lượng</td>
                    <td >Hành động</td>
                </tr>    
            </thead>
            
            <c:forEach items="${sessionScope.cart}" var="i">
                
                <c:set var="no" value="${no + 1}"></c:set>

                    <tr>
                        <td>${no}</td>
                    <td>${i.key.mcate}</td>
                    <td>${i.key.name}</td>
                    <td><img src="${i.key.address}" alt="anh" style="max-height: 50px; max-width: 50px"></td>
                    <td><strong><fmt:formatNumber value="${i.key.price * i.value}" type="currency"/></strong></td>
                    <td><input type="number" value="${i.value}" min="1" max="20" name="txtquantity" onchange="sendRedirect(${i.key.id}, this)"></td>

                    <td>
                        <form action="MainController" method="post">
                            <div class="btn-group">
                                <input type="hidden" name="btaction" value="remove" />
                                <input type="hidden" name="mealid" value="${i.key.id}"/>
                                <button class="btn" value="EditCart" name="action">Xóa</button>
                            </div>
                        </form>
                    </td>
                    
                </tr>
                <c:set var="sub" value="${i.key.price * i.value}"></c:set>
                <c:set var="subtotal" value="${sub + subtotal}"></c:set>
                
            </c:forEach>
        
    </table>
    <c:set var="fax" value="0"></c:set>
    <c:set var="total" value="${fax + subtotal}"></c:set>
    <c:if  test="${not empty sessionScope.cart}">
        <div class="container my-5">
            <div class="order-summary">
                <div class="summary-title">Tóm tắt đơn hàng </div>
                <div class="summary-item">
                    <span>Món ăn</span>
                    <span><strong><fmt:formatNumber value="${subtotal}" type="currency"/></strong></span>   
                </div>
                <div class="summary-item">
                    <span>Dịch vụ</span>
                    <span><strong><fmt:formatNumber value="${fax}" type="currency"/></strong></span>
                </div>
                <div class="summary-total">
                    <span>Tổng cộng</span>
                    <span><strong><fmt:formatNumber value="${total}" type="currency"/></strong></span>
                </div>
                <form action="MainController" method="post"> 
                    <button type="submit" name="action" value="CheckOut" class="checkout-button">Check out</button>
                </form>
            </div>
        </div>
    </c:if>
    <script>
        function sendRedirect(mealId, input) {
            if (input.value < 1) {
                input.value = 1;
            } else if (input.value > 20) {
                input.value = 20;
            }

            var url = 'MainController?action=EditCart&mealid=' + mealId + '&txtquantity=' + input.value;
            window.location.href = url;

        }
    </script>

</section>
<%@include file="footer.jsp" %>
