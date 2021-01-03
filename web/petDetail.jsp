<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>宠物详情</title>

    <link rel="stylesheet" type="text/css" href="assets/css/pet.css"/>
    <link rel="stylesheet" type="text/css" href="assets/css/main.css"/>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- <link rel="stylesheet" href="css\font-awesome.min.css"> -->
    <script src="assets/js/jquery-3.2.1.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>



    <script src="assets/layer/layer.js"></script>

</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">宠物详情</h3>
            </div>
            <div class="panel-body">
                <p id="petsid" hidden>${pet.sid}</p>

                <!--add  form-->
                <div class="result-wrap">
                    <div class="result-content">
                        <form  id="add-pet"  enctype="multipart/form-data">
                            <table class="insert-tab" width="100%">
                                <tbody>
                                <tr>
                                    <th>
                                      宠物名：
                                    </th>
                                    <td>
                                        <span>${pet.name}</span>
                                    </td>
                                </tr>
                                <tr>
                                    <th width="120">
                                        种类：
                                    </th>
                                    <td>
                                        <span id="sid"></span>
                                    </td>
                                </tr>
                                <tr>
                                    <th width="120">
                                        <i class="require-red">*</i>是否绝育：
                                    </th>
                                    <td>

                                        <c:if test="${pet.isJY == 1}">
                                            <span>是</span>
                                        </c:if>
                                        <c:if test="${pet.isJY == 2}">
                                            <span>否</span>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <th width="120">
                                        价钱：
                                    </th>

                                    <td>
                                        <span>${pet.character}</span>
                                    </td>
                                </tr>
                                <tr>
                                    <th>发布时间：</th>
                                    <td>
                                        <span>${pet.createTime}</span>
                                    </td>
                                </tr>
                                <tr>
                                    <th>所属宠物店：</th>
                                    <td>
                                        <span>${pet.organization}</span>
                                    </td>
                                </tr>
                                <tr>
                                    <th>饲主：</th>
                                    <td>
                                        <span>${pet.feeder}</span>
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        宠物图片：
                                    </th>
                                    <td>
                                        <img id="preview"  style="diplay:inline-block;width: 150px;margin-left: 10px" src="${pet.img}"/>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
                <!--/add form-->

            </div>
        </div>

    </div>
</div>



</body>
</html>



<!--图片及时预览-->
<script type="text/javascript">

    //获取分类列表
    $(document).ready(function () {
        var sid = $('#petsid').text();
        var opt;
        $.get("speciesQuery","",function (data,status) {
            if(data){
                data.forEach(function (item) {
                  if(item.id == sid) {
                      $("#sid").text(item.name)
                      return
                  }
                })
            }
        });
    });

</script>
