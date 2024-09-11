<%-- 
    Document   : meallist
    Created on : Jul 6, 2024, 11:59:50 AM
    Author     : baolee
--%>
<%@page import="java.util.List"%>
<%@page import="dto.Account"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="dashboard.jsp" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link href="css/list.css" rel="stylesheet" >
<style>
    .modal {
        display: none; /* Ẩn modal mặc định */
        position: fixed;
        z-index: 2; /* Z-index cao hơn nội dung chính */
        left: 37%;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0,0,0,0.4);
        align-items: center;
        justify-content: center;
    }
    .modal h2{
        margin: 0 auto;
    }

    /* Modal content */
    .modal-content {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        width: 90%;
        max-width: 600px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        position: relative;
    }

    /* Close button */
    .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
        position: absolute;
        top: 10px;
        right: 20px;
        cursor: pointer;
    }

    .close:hover,
    .close:focus {
        color: black;
        text-decoration: none;
    }

    .modal-header {
        text-align: center;
        margin-bottom: 20px;
    }

    .modal-body {
        display: flex;
        flex-direction: column;
        gap: 15px;
    }

    .modal-body img {
        height: 205px;
        width: 368px;
        margin: 0 auto;
        object-fit: cover;
    }

    .modal-body input, .modal-body textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    .modal-body textarea {
        resize: vertical;
    }

    .modal-footer {
        text-align: center;
        margin-top: 20px;
    }

    .modal-footer button {
        padding: 10px 20px;
        border: none;
        background-color: #5cb85c;
        color: white;
        border-radius: 4px;
        cursor: pointer;
    }

    .modal-footer button:hover {
        background-color: #4cae4c;
    }

    /* Lớp mờ */
    .blur {
        filter: blur(5px);
    }

    .modal-footer button{
        margin: 0 auto;
    }



    .btn-add {
        right:10%;
        position: absolute;
        width: 150px;
        height: 40px;
        cursor: pointer;
        display: flex;
        align-items: center;
        border: 1px solid #34974d;
        background-color: #3aa856;
    }

    .btn-add, .button__icon, .button__text {
        transition: all 0.3s;
    }

    .btn-add .button__text {
        color: #fff;
        font-weight: 600;
    }

    .btn-add .button__icon {
        position: absolute;
        transform: translateX(103px);
        height: 100%;
        width: 39px;
        background-color: #34974d;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .btn-add.svg {
        width: 30px;
        stroke: #fff;
    }

    .btn-add:hover {
        background: #34974d;
    }



    .button:hover .button__icon {
        width: 148px;
        transform: translateX(0);
    }

    .btn-add:active .button__icon {
        background-color: #2e8644;
    }

    .btn-add:active {
        border: 1px solid #2e8644;
    }
</style>
<div class="content w-100" >
    <h1>Danh sách món ăn</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>ID loại</th>
                <th>Tên</th>
                <th>Công thức</th>
                <th>Giá</th>
                <th>Trạng thái</th>
                <th>Cập nhật</th>
            </tr>
        </thead>
        <tbody>

            <c:forEach var="meal" items="${requestScope.ListMeal}">
                <tr>
                    <td>${meal.id}</td>
                    <td>${meal.mcate}</td>
                    <td>${meal.name}</td>
                    <td>${meal.recipe}</td>
                    <td>${meal.price}</td>
                    <td>${meal.status}</td>
                    <td class="action-links">
                        <c:url value="#" var="statusUrl">
                            <c:param name="" value="${meal.id}" />
                        </c:url>
                        <button onclick="openModal('${meal.id}', '${meal.mcate}', '${meal.name}', '${meal.recipe}', '${meal.price}', '${meal.status}')">Cập nhật</button>

                    </td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
</div>
</div>
<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2 class="modal-header">Update Product</h2>
        <form id="updateForm" action="MainController" method="post">
            <div class="modal-body">
                <label for="mealID">Meal ID:</label>
                <input type="text" id="mealID" name="mealID" readonly=""><br>

                <label for="mcate">Category:</label>
                <input type="text" id="mcate" name="mcate" required><br>

                <label for="name">Product Name:</label>
                <input type="text" id="name" name="name" required><br>

                <label for="recipe">Recipe:</label>
                <input type="text" id="recipe" name="recipe" required><br>

                <label for="price">Price:</label>
                <input type="number" id="price" name="price" step="1000" required><br>

                <label for="status">Status:</label>
                <input type="number" id="status" name="status" required><br>


            </div>
            <div class="modal-footer">
                <button  type="submit" name="action" value="UpdateMeal">Update</button>
            </div>
        </form>
    </div>
</div>

<script>
    var modal = document.getElementById("myModal");
    var span = document.getElementsByClassName("close")[0];
    var mainWrapper = document.getElementById("mainWrapper");

    span.onclick = function () {
        modal.style.display = "none";
        mainWrapper.classList.remove("blur");
    }

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
            mainWrapper.classList.remove("blur");
        }
    }
    function openModal(id, cate, name, recipe, price, status) {
        document.getElementById("mealID").value = id.trim();
        document.getElementById("mcate").value = cate.trim();
        document.getElementById("name").value = name.trim();
        document.getElementById("recipe").value = recipe.trim();
        document.getElementById("price").value = price.trim();
        document.getElementById("status").value = status.trim();

        modal.style.display = "block";
        mainWrapper.classList.add("blur");
    }
</script>
<script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.umd.min.js"
    https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js
></script>
</body>
</html>
