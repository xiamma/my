<%--
  Created by IntelliJ IDEA.
  User: love
  Date: 2020/12/31
  Time: 下午9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link href="assets/css/bootstrap.min.css"  rel="stylesheet">
    <link href="assets/css/login.css" rel="stylesheet">
    <script src="assets/js/jquery-3.2.1.js"></script>
    <script src="assets/layer/layer.js"></script>
</head>
<body class="text-center">
<form name="registerForm" class="form-signin" action="register" method="post" onsubmit="return myCheck()">
    <img class="mb-4" src="assets/images/logo.jpg" alt="" width="72" height="72" style="CURSOR: hand" onclick='window.location.href="/index"'>
    <h1 class="h3 mb-3 font-weight-normal">宠物管理系统-- 注 册</h1>
    <input type="hidden" name="type" value="register">
    <input type="text"  name="username" class="form-control" placeholder="用户名" required="" autofocus="">
    <select class="form-control" name="role"  placeholder="请选择"  required="">
        <option disabled selected value>请选择</option>
        <option value="2">宠物店</option>
        <option value="3">饲主</option>
    </select>
    <input type="password" name="password" class="form-control" placeholder="请输入密码" required="">
    <input type="password" id="password1" name="login_psw1" class="form-control" placeholder="请再次输入密码" required="">
    <div class="checkbox mb-3">
    </div>

    <div class=" col-md-12">
        <p class="blog-label-error" style="color:red;" >${data}</p>
    </div>


    <button class="btn btn-lg btn-primary " style="width: 100px " type="submit" >提 交</button>
    <button class="btn btn-lg btn-primary " style="width: 100px " type="button" onclick="window.location.href='login.jsp'" >登 录</button>
</form>
</body>
</html>

<script type="text/javascript">
    function myCheck() {
        var pwd1 = document.registerForm.password.value;
        var pwd2 = document.registerForm.password1.value;
        var loginName = document.registerForm.username.value;
        if (loginName.length < 3){
            layer.msg("用户名长度需大于等于3!", {icon: 2});
            return false;
        }
        if (pwd1 != pwd2){
            layer.msg("两次输入密码不相同!", {icon: 2});
            return false;
        }
        if (pwd1.length < 6){
            layer.msg("密码长度需大于6!", {icon: 2});
            return false;
        }
        return true;
    }
</script>
