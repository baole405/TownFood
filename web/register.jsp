<%-- 
    Document   : login
    Created on : Jun 26, 2024, 10:22:30 AM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<!--<div class="container d-flex justify-content-center align-items-center vh-100 login-container">
    <div class="card" style="width: 20rem;">
        <div class="card-body">
            <h5 class="card-title text-center">Register</h5>
            <form onsubmit="return validatePassword(event)" action="Register" method="post">
                 UserName input 
                <div class="form-outline mb-4">
                    <input type="text" id="name" class="form-control" name="txtname"/>
                    <label class="form-label" for="name">UserName</label>
                </div>

                 Password input 
                <div class="form-outline mb-4">
                    <input type="password" id="password" class="form-control" name="txtpassword"/>
                    <label class="form-label" for="password2">Password</label>
                </div>

                <div class="form-outline mb-4">
                    <input type="password" id="password2" class="form-control" />
                    <label class="form-label" for="password2">Confirm Password</label>
                </div>
                 Submit button 
                <button type="submit" class="btn btn-primary btn-block">Register</button>

                 Message display 

 Register link 
<div class="mt-3 text-center">
    <p>Đã có tài khoản ? <a href="login.jsp">Login</a></p>
</div>
</form>

</div>
</div>
</div>-->
<section class=" text-center text-lg-start">
    <style>
        .rounded-t-5 {
            border-top-left-radius: 0.5rem;
            border-top-right-radius: 0.5rem;
        }

        @media (min-width: 992px) {
            .rounded-tr-lg-0 {
                border-top-right-radius: 0;
            }

            .rounded-bl-lg-5 {
                border-bottom-left-radius: 0.5rem;
            }
            #loginform {
                margin-top: 200px; 
                margin-bottom: 200px;
            }
        }
    </style>
    <div class="card " id="loginform">
        <div class="row g-0 d-flex align-items-center">
            <div class="col-lg-3"></div>
            <div class="col-lg-2 d-none d-lg-flex">
                <img src="img/openart-image_yfh4QFPK_1719128796338_raw.jpg" alt="Img"
                     class="w-100 rounded-t-5 rounded-tr-lg-0 rounded-bl-lg-5" />
            </div>
            <div class="col-lg-4">
                <div class="card-body py-5 px-md-5 ">

                    <form onsubmit="return validatePassword(event)" action="MainController" method="post">
                        <!-- Email input -->
                        <div data-mdb-input-init class="form-outline mb-4">
                            <input type="text" id="username" class="form-control" name="txtname"/>
                            <label class="form-label" for="username">Tên đăng nhập</label>
                        </div>
                        <!-- Password input -->
                        <div data-mdb-input-init class="form-outline mb-4">
                            <input type="password" id="password" class="form-control" name="txtpassword"/>
                            <label class="form-label" for="password">Mật khẩu</label>
                        </div>        
                        <div data-mdb-input-init class="form-outline mb-4">
                            <input type="password" id="password2" class="form-control" name="txtpassword"/>
                            <label class="form-label" for="password2">Nhập lại mật khẩu</label>
                        </div>        

                        <!-- 2 column grid layout for inline styling -->

                        <!-- Submit button -->
                        <button type="submit" name="action" value="Register" class="btn btn-primary btn-block">Đăng kí </button>
                        <c:if test="${not empty message && not empty messageType}">
                            <div class="alert alert-${messageType == 'success' ? 'success' : 'danger'} mt-3" role="alert">
                                ${message}
                            </div>
                        </c:if>
                        <div class="col text-center">Đã có tài khoản ?
                            <!-- Simple link -->
                            <a href="login.jsp">Login </a>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="footer.jsp" %>
