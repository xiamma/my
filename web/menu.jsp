<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: love
  Date: 2020/12/29
  Time: 下午5:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-3">
    <div class="list-group">

        <a href="pet.jsp" class="list-group-item active" target="test">宠物管理</a>

        <c:if test="${user.role == 3}">
            <a href="myPet.jsp" class="list-group-item" target="test">我的宠物</a>
        </c:if>

        <c:if test="${user.role == 1}">
            <a href="species.jsp" class="list-group-item" target="test">种类管理</a>
            <a href="user.jsp" class="list-group-item " target="test">用户管理</a>
        </c:if>

    </div>
</div>

<script>


    $(".list-group a").click(function () {
        $(".list-group a").removeClass("active");
        $(this).addClass("active");
    })


</script>
