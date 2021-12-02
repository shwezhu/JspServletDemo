<%--
  Created by IntelliJ IDEA.
  User: shaowen
  Date: 12/1/21
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="./css/home.css"/>
</head>
<body>

<div class="top_nav_area">
    <img src="./OtherResources/head.jpg" class="head" alt="">
    <h3 style="position: absolute;left: 60px;top: 2px;">xxx Management System</h3>
</div>

<div class="sidenav_area">
    <a class="sidenav_bar" href="">Home</a>
    <a class="sidenav_bar" href="">Students info</a>
</div>

<div class="search_area">
    <h3>Manage students information</h3>
    <div>
        <form method="post" id="SearchForm" action="${pageContext.request.contextPath}/SearchServletName">
            <label>Student ID<input type="text"></label>
            <button>Search</button>
        </form>
    </div>
</div>

<div class="add_area">

</div>

</body>
</html>

<script>
    function verify() {
        document.getElementById("SearchForm").submit();
    }
</script>