<%-- 
    Document   : header
    Created on : Jun 22, 2024, 1:55:31 PM
    Author     : baolee
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/mytags" prefix="t" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TownFood</title>
        <!-- Font Awesome -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
            />
        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
            />
        <!-- MDB -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.min.css"
            rel="stylesheet"
            />
        <!--<link href="css/newcss.css" rel="stylesheet" />-->
        <link href="css/menucss.css" rel="stylesheet" />
        <link href="css/home.css" rel="stylesheet" />
        <script src="js/checkpass.js" defer></script>
        <script src="js/carousel.js" defer></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>-->
        <style>

        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-light  fixed-top"  style="background-color: #DEEBF3;">
            <div class="container">
                <!-- Brand -->
                <div style="    
                     height: 100px;
                     width: 100px;
                     border-radius: 50%;
                     background-color: #8ba39f52;
                     position: relative;
                     ">
                    <a class="navbar-brand me-auto" href="MainController?action=Home" style="position: absolute;top: 15%; right: 15%;">
                        <img
                            src="img/bg.ai_1719131872236.png"
                            height="60"
                            alt="Logo"
                            loading="lazy"
                            />
                    </a>
                </div>
                <!-- Brand-->

                <button
                    data-mdb-collapse-init
                    class="navbar-toggler"
                    type="button"
                    data-mdb-target="#navbarToggler"
                    aria-controls="navbarToggler"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                    >
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse justify-content-evenly " id="navbarToggler">

                    <ul class="navbar-nav mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="menu.jsp">Menu</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a
                                data-mdb-dropdown-init
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                aria-expanded="false"
                                >
                                Plan
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li>
                                    <a class="dropdown-item" href="#">Recommend Plan</a>
                                </li>
                                <li><hr class="dropdown-divider" /></li>
                                <li>
                                    <a class="dropdown-item" href="#">Personal Plan</a>
                                </li>
                            </ul>           
                        </li>

                    </ul>

                    <div class="d-flex input-group w-auto" action="menu.jsp"  method="post">
                        <input
                            id="searchInput"
                            type="text"
                            name="txt"
                            class="form-control"
                            placeholder="Meal name"
                            aria-label="Search"
                            oninput="searchByName(this)"
                            />
                        <button
                            data-mdb-ripple-init
                            class="btn btn-outline-primary"
                            type="button"   
                            data-mdb-ripple-color="dark"
                            onclick="window.location.href = 'menu.jsp'"
                            >
                            Search
                        </button>
                    </div>
                </div>

                <div class="d-flex align-items-center ">
                    <t:Avatar></t:Avatar>
                </div>

            </div>
        </nav>
