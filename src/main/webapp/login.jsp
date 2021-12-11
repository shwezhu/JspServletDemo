<%--
  Created by IntelliJ IDEA.
  User: shaowen
  Date: 12/1/21
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>

<%--Without the following code, web pages with Chinese characters would appear unreadable code.--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>

    <script type="text/javascript">
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
            document.getElementById("loginForm").submit();
        }
    </script>
</head>

<body>
    <div id="content">
        <form method="post" id="loginForm" action="${pageContext.request.contextPath}/LoginServletName">
            <div id="login">
                <h3 style="color: aquamarine">Welcome to this world</h3>
                <label for="username"></label><input type="text" id="username" name="username" placeholder="username"/>
                <label for="password"></label><input type="password" id="password" name="password" placeholder="password"/>
                <button type="button" onclick="verify()" style="margin-right: 85px;">Login</button>
                <a href = "register.jsp" style="color: aquamarine;">Register now</a>
            </div>
        </form>
    </div>
</body>
</html>