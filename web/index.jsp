<%--
  Created by IntelliJ IDEA.
  User: love
  Date: 2020/12/29
  Time: 下午5:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>宠物管理系统</title>
    <link type="text/css" href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="css\font-awesome.min.css"> -->
    <script src="assets/js/jquery-3.2.1.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
  </head>
  <body>


   <jsp:include page="nav.jsp"/>

  <div class="container-fluid">
    <div class="row">
      <jsp:include page="menu.jsp"/>

      <div class="col-md-9">


        <iframe name="test" runat="server" src="pet.jsp" width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" allowtransparency="yes">


        </iframe>
      </div>
    </div>
  </div>
  </body>
</html>
