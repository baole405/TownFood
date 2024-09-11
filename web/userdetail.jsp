<%-- 
    Document   : userdetail
    Created on : Jul 7, 2024, 5:01:24 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<style>


    .card-registration .select-input.form-control[readonly]:not([disabled]) {
        font-size: 1rem;
        line-height: 2.15;
        padding-left: .75em;
        padding-right: .75em;
    }
    .card-registration .select-arrow {
        top: 13px;
    }
</style>
        <section class="vh-100 gradient-custom">
            <div class="container py-5 h-100">
                <div class="row justify-content-center align-items-center h-100">
                    <div class="col-12 col-lg-9 col-xl-7">
                        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                            <div class="card-body p-4 p-md-5">
                                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Thông tin người dùng</h3>
                                <form action="MainController" method="post">

                                    <div class="row ">
                                        <div class="col-md-6 mb-4">

                                            <div data-mdb-input-init class="form-outline">
                                                <input type="text" id="firstName" class="form-control form-control-lg" name="name"/>
                                                <label class="form-label" for="firstName">Họ và tên</label>
                                            </div>

                                        </div>
                                        <div class="col-md-6 mb-4 ">

                                            <div data-mdb-input-init class="form-outline">
                                                <input type="email" id="emailAddress" class="form-control form-control-lg" name="email"/>
                                                <label class="form-label" for="emailAddress">Email</label>
                                            </div>

                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6 mb-4 d-flex align-items-center">
                                            <div data-mdb-input-init class="form-outline">
                                                <input type="tel" id="phoneNumber" class="form-control form-control-lg" name="phone"/>
                                                <label class="form-label" for="phoneNumber">Số điện thoại</label>
                                            </div>

                                        </div>
                                        <div class="col-md-6 mb-4">

                                            <h6 class="mb-2 pb-1">Giới tính: </h6>

                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender" id="femaleGender"
                                                       value="Female" checked />
                                                <label class="form-check-label" for="femaleGender">Nữ</label>
                                            </div>

                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender" id="maleGender"
                                                       value="Male" />
                                                <label class="form-check-label" for="maleGender">Nam</label>
                                            </div>

                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender" id="otherGender"
                                                       value="Order" />
                                                <label class="form-check-label" for="otherGender">Khác</label>
                                            </div>

                                        </div>
                                    </div>

                                    <div class="row">

                                        <div class="col-md-12 mb-4">

                                            <div data-mdb-input-init class="form-outline">
                                                <input type="text" id="address" class="form-control form-control-lg" name="address" />
                                                <label class="form-label" for="address">Địa chỉ</label>
                                            </div>

                                        </div>
                                    </div>


                                    <div class="mt-4 pt-2">
                                        <input data-mdb-ripple-init class="btn btn-primary btn-lg" type="submit" value="UserDetail" name="action"/>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
<%@include file="footer.jsp" %>
