<%-- 
    Document   : dashboard
    Created on : Jul 6, 2024, 11:20:44 AM
    Author     : baolee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


        <style>
            .sidebar {
                height: 100vh;
            }
            .button {
                display: flex;
                align-items: center; 
            }
        </style>
    </head>
    <body>
        <div class="d-flex" id="mainWrapper">
            <div  class="d-flex flex-column flex-shrink-0 p-3 bg-light sidebar" style="width: 280px;">
                <a href="#" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
                    <span class="fs-4">${sessionScope.LoginAccount.name}</span>
                </a>
                <hr>
                <ul class="nav nav-pills flex-column mb-auto">

                    <li>
                        <a href="#" class="nav-link link-dark dropdown button "
                           class="btn btn-primary dropdown-toggle"
                           href="#"
                           role="button"
                           id="dropdownMenuLink"
                           data-mdb-dropdown-init
                           data-mdb-ripple-init
                           aria-expanded="false"
                           >
                            <i class="fas fa-users me-2  fa-2x"></i>
                            Account
                        </a>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <li><a class="dropdown-item" href="MainController?action=GetUser">Manage Account</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="nav-link link-dark dropdown button"
                           class="btn btn-primary dropdown-toggle"
                           href="#"
                           role="button"
                           id="dropdownMenuLink"
                           data-mdb-dropdown-init
                           data-mdb-ripple-init
                           aria-expanded="false"
                           >
                            <i class="fas fa-carrot me-2 fa-2x"></i>
                            Ingredient
                        </a>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <li><a class="dropdown-item" href="MainController?action=GetIngredient">Manage Ingredient</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="nav-link link-dark dropdown button"
                           class="btn btn-primary dropdown-toggle"
                           href="#"
                           role="button"
                           id="dropdownMenuLink"
                           data-mdb-dropdown-init
                           data-mdb-ripple-init
                           aria-expanded="false"
                           >
                            <i class="fas fa-utensils me-2  fa-2x"></i>
                            Meal
                        </a>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <li><a class="dropdown-item" href="MainController?action=GetMeal">Manage Meal</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="nav-link link-dark dropdown button"
                           class="btn btn-primary dropdown-toggle"
                           href="#"
                           role="button"
                           id="dropdownMenuLink"
                           data-mdb-dropdown-init
                           data-mdb-ripple-init
                           aria-expanded="false"
                           >
                            <i class="fas fa-clipboard-list me-2 fa-2x"></i>
                            Order
                        </a>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <li><a class="dropdown-item" href="MainController?action=GetOrder">View Order</a></li>
                            <li><a class="dropdown-item" href="MainController?action=SearchOrder">Search Order</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="nav-link link-dark dropdown button"
                           class="btn btn-primary dropdown-toggle"
                           href="#"
                           role="button"
                           id="dropdownMenuLink"
                           data-mdb-dropdown-init
                           data-mdb-ripple-init
                           aria-expanded="false"
                           >
                            <i class="fas fa-calendar me-2 fa-2x"></i>
                            Weekly Plan
                        </a>

                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                </ul>
                <hr>
                <div class="dropdown">
                    <a
                        data-mdb-dropdown-init
                        class="dropdown-toggle d-flex align-items-center hidden-arrow"
                        href="#"
                        id="navbarDropdownMenuAvatar"
                        role="button"
                        aria-expanded="false"
                        >
                        <img
                            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFCzxivJXCZk0Kk8HsHujTO3Olx0ngytPrWw&s"
                            class="rounded-circle"
                            height="50"
                            alt="User Icon"
                            loading="lazy"
                            />
                    </a>
                    <ul
                        class="dropdown-menu dropdown-menu-end"
                        aria-labelledby="navbarDropdownMenuAvatar"
                        >
                        <li>
                            <a class="dropdown-item" href="MainController?action=Logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
