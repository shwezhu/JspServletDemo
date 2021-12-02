<%--
  Created by IntelliJ IDEA.
  User: shaowen
  Date: 12/1/21
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create account</title>
    <link rel="stylesheet" type="text/css" href="./css/login.css"/>
</head>

<body>
<div id="content">
    <form method="post" id="RegisterForm" action="${pageContext.request.contextPath}/RegisterServletName">
        <div id="signup">
            <h3 style="color: aquamarine">Create an account</h3>
            <label for="username"></label><input type="text" id="username" name="username" placeholder="username"/>
            <label for="password"></label><input type="password" id="password" name="password" placeholder="password"/>
            <button type="button" onclick="verify()" style="position:absolute; top: 125px; left: 200px;">Register</button>
        </div>
    </form>
</div>
</body>
</html>

<script>
    function verify() {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        if (username === '') {
            alert("username can't empty!");
            return;
        }
        if (password === '') {
            alert("password can't empty!");
            return;
        }
        document.getElementById("RegisterForm").submit();
    }
</script>