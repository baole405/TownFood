<%-- 
    Document   : footer
    Created on : Jun 22, 2024, 1:55:43 PM
    Author     : trung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>

    .information p{
        color: #ffffff94;
    }
    .social{
        background-color: #e0dcdc;
        padding: 0 0 0 15px;
    }
</style>
<!-- Footer -->
<footer class="text-center text-lg-start text-muted " style="background-color: #333333;">
    <!-- Section: Social media -->
    <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
        <!-- Left -->
        <div class="me-5 d-none d-lg-block" style="color:white;">
            <span>Liên hệ với chúng tôi qua:</span>
        </div>
        <!-- Left -->

        <!-- Right -->
        <div class="social">
            <a href="" class="me-4 text-reset">
                <i class="fab fa-facebook-f"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-google"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-github"></i>
            </a>
        </div>
        <!-- Right -->
    </section>
    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="" style="color:white;">
        <div class="container text-center text-md-start mt-2">
            <!-- Grid row -->
            <div class="row mt-3">
                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Content -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        <i class="fas fa-gem me-3"></i>Little Hometown
                    </h6>
                    <p>
                        Sologan ở đây 
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        CHƯA BIẾT
                    </h6>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <h6>THANH TOÁN</h6>

                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">lIÊN HỆ</h6>
                    <p><i class="fas fa-home me-3"></i> Tp.Hồ Chí Minh, Việt Nam</p>
                    <p>
                        <i class="fas fa-envelope me-3"></i>
                        thebaolee2701@gmail.com
                    </p>
                    <p><i class="fas fa-phone me-3"></i> 091 317 3378</p>
                </div>
                <!-- Grid column -->
            </div>
            <!-- Grid row -->
        </div>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <div class="text-center " style="background-color: rgba(0, 0, 0, 0.05);">
        © 2024 Copyright:
        <a class="text-reset fw-bold" href="">TheTrung</a>
    </div>
    <!-- Copyright -->
        <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05) ;color:white;">
        <!--Back to top-->
        <div class="back-to-top" style="    margin-bottom: 10px;">
            <a style="    color: #49a3b5; /* Màu vàng nhạt */" id="back-to-top" href="">Back to top</a>
        </div>
        <!--Back to top-->
</footer>
<!-- Footer -->
<script>
    function validatePassword(event) {
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("password2").value;

    if (password !== confirmPassword) {
        document.getElementById("message").textContent = "Passwords do not match.";
        document.getElementById("message").style.color = "red";
        return false;
    } else {
        document.getElementById("message").textContent = "Passwords match.";
        document.getElementById("message").style.color = "green";
        return true;
    }
}
    function searchByName(param) {
        var txtSearch = param.value;
        $.ajax({
            url: "/FoodStore/SearchServlet",
            type: "GET",
            data: {
                txt: txtSearch
            },
            success: function (data) {
                var row = document.getElementById("testsearch");
                row.innerHTML = data;
            },
        });
    }
    function hideInputIfNotMenuPage() {
        const currentPage = window.location.pathname.split('/').pop();
        if (currentPage !== 'menu.jsp') {
            document.getElementById('searchInput').style.display = 'none';
        }
    }
    document.getElementById("back-to-top").addEventListener("click", function (event) {
        event.preventDefault();
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        });
    });
    // Gọi hàm khi trang được tải
    window.onload = hideInputIfNotMenuPage;
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.umd.min.js"
></script>
</body>
</html>
