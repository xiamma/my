<%--
  Created by IntelliJ IDEA.
  User: love
  Date: 2020/12/29
  Time: 下午9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台登录</title>
    <link href="assets/css/bootstrap.min.css"  rel="stylesheet">
    <link href="assets/css/login.css" rel="stylesheet">
    <script src="assets/js/jquery-3.2.1.js"></script>
</head>
<body class="text-center">
<%
    //防止重复登录
    if (session.getAttribute("user")!=null)
        response.sendRedirect("index");
%>

<form class="form-signin"  method="post" action="login">
    <img class="mb-4" src="assets/images/logo.jpg" alt="" width="300" height="300" style="CURSOR: hand" onclick='window.location.href="/login"'>
    <h1 class="h3 mb-3 font-weight-normal">宠物管理系统-- 登 录</h1>
    <input type="hidden" name="type" value="login">
    <input type="text" id="login_username" name="username" class="form-control" required="" placeholder="用户名" >
    <input type="password" id="password" name="password" class="form-control" required="" placeholder="密码">


        <div class=" col-md-12">
            <p class="blog-label-error" style="color:red;" >${message}</p>
        </div>

    <button class="btn btn-lg btn-primary " style="width: 100px " type="submit">登 录</button>
    <button class="btn btn-lg btn-primary " style="width: 100px " type="button" onclick="window.location.href='register.jsp'" >注 册</button>

</form>

</body>
</html>
