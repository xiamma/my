<%--
  Created by IntelliJ IDEA.
  User: leslee
  Date: 2020/12/30
  Time: 下午11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=UTF-8" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>宠物报道</title>

    <link href="assets/css/bootstrap.min.css" rel="stylesheet">


    <script src="assets/js/jquery-3.2.1.js"></script>
    <script src="assets/layer/layer.js"></script>
    <script type="text/javascript" src="assets/js/wangEditor.min.js"></script>

</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">宠物报道</h3>
            </div>
            <div class="panel-body">
                <input type="hidden" id="id" value="${pet.id}">
                <div id="myEditor">
                    ${pet.detail}
                </div>
                <button class="btn btn-primary btn-lg" style="margin:10px 0 0 10px;" onclick="saveHtml()">提 交</button>
                <input class="btn btn6 btn-lg" style="margin:10px 0 0 10px;" onclick="history.go(-1)" value="返回" type="button">
            </div>
        </div>

    </div>
</div>

</body>
</html>

<script type="text/javascript">
    const E = window.wangEditor
    const editor = new E('#myEditor')

    // 设置编辑区域高度为 500px(先设置高度再create())
    editor.config.height = 500


    // 或者 const editor = new E( document.getElementById('div1') )
    editor.create()

    // 配置 server 接口地址
    editor.config.uploadImgServer = 'uploadImg'

    // 禁用粘贴时过滤样式
    editor.config.pasteFilterStyle = false
    // 启用base64
    // editor.config.uploadImgShowBase64 = true
    // 配置全屏功能按钮是否展示
    editor.config.showFullScreen = true

    // 配置隐藏插入网络图片
    // editor.config.showLinkImg = false


    function saveHtml() {
       var id = $("#id").val();
       var detail = editor.txt.html();

        $.ajax({
            url: 'petEditor' ,  /*这是处理文件上传的servlet*/
            type: 'post',
            data: {
                id,
                detail
            },
            dataType: 'json',
            success: function (data) {
                if(data.status == 200) {
                    layer.msg(data.msg, {icon: 1})
                    window.setTimeout("window.location.href='pet.jsp'", 1000);
                }else{
                    layer.msg(data.msg, {icon: 2})
                }
            }
        });


    }
</script>
