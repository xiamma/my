<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加宠物</title>

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
                <h3 class="panel-title">新增宠物</h3>
            </div>
            <div class="panel-body">

                <!--add  form-->
                <div class="result-wrap">
                    <div class="result-content">
                        <form  id="add-pet"  enctype="multipart/form-data">
                            <input type="hidden" value="add" name="type">
                            <table class="insert-tab" width="100%">
                                <tbody>
                                <tr>
                                    <th>
                                        <i class="require-red">*</i>宠物名：</th>
                                    <td>
                                        <input class="common-text required" id="title" name="name" size="50"  type="text">
                                    </td>
                                </tr>
                                <tr>
                                    <th width="120">
                                        <i class="require-red">*</i>种类：</th>
                                    <td>
                                        <select name="sid" id="sid" class="required common-text">
                                            <option value="" disabled selected>请选择</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th width="120">
                                        <i class="require-red">*</i>是否绝育：
                                    </th>
                                    <td>
                                        <select name="isJY" id="isJY" class="required common-text" >
                                            <option value="" disabled selected>请选择</option>
                                            <option value="1">是</option>
                                            <option value="2">否</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th width="120">
                                        <i class="require-red">*</i>价钱：</th>
                                    <td>
                                        <input class="common-text" name="character" size="50"  type="text">
                                    </td>
                                </tr>

                                <tr>
                                    <th>
                                        <i class="require-red">*</i>宠物图片：</th>
                                    <td>
                                        <input type=file name="img" id="img" onchange="javascript:setImagePreview();" accept="image/png,image/jpeg">
                                        <img id="preview"  style="diplay:inline-block;width: 150px;margin-left: 10px" />
                                    </td>
                                </tr>
                                <tr>
                                    <th></th>
                                    <td>
                                        <button class="btn btn-primary btn6 mr10" type="button" onclick="doUpload()">提交</button>
                                        <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
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
                var rows = data
                //循环读入数据并添加到院系列表中
                $.each(rows,function (i,item) {
                    if(item.id == sid)
                        opt="<option value="+item.id+" selected>"+item.name+"</option>";
                    else
                        opt="<option value="+item.id+">"+item.name+"</option>";
                    $("#sid").append(opt);
                })
            }
        });
    });



    function setImagePreview() {
        var docObj = document.getElementById("img");
        var imgObjPreview = document.getElementById("preview");
        if (docObj.files && docObj.files[0]) {
            //火狐下，直接设img属性
            imgObjPreview.style.width = '150px';
            imgObjPreview.style.display="inline-block";
            imgObjPreview.style.marginLeft="10px";
            //imgObjPreview.style.height = '120px';
            //imgObjPreview.src = docObj.files[0].getAsDataURL();
            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
            imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
        } else {
            //IE下，使用滤镜
            docObj.select();
            var imgSrc = document.selection.createRange().text;
            var localImagId = document.getElementById("localImag");
            //必须设置初始大小
            localImagId.style.width = "50px";
            //localImagId.style.height = "200px";
            //图片异常的捕捉，防止用户修改后缀来伪造图片
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localImagId.filters
                    .item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            } catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
        }
        return true;
    }




    //异步提交表单并上传图片
    function doUpload() {
        var formData = new FormData($( "#add-pet" )[0]);

        if(!formData.get("name")){
            layer.msg("请输入宠物名！",{icon: 2})
            return;
        }
        if(!formData.get("sid")){
            layer.msg("请选择种类！",{icon: 2})
            return;
        }
        if(!formData.get("isJY")){
            layer.msg("请选择是否绝育！",{icon: 2})
            return;
        }
        if(!formData.get("character")){
            layer.msg("请输入宠物价钱！",{icon: 2})
            return;
        }
        if(!formData.get("img")){
            layer.msg("请上传宠物照片！",{icon: 2})
            return;
        }

        $.ajax({
            url: 'petUpdate' ,  /*这是处理文件上传的servlet*/
            type: 'POST',
            data: formData,
            dataType: 'json',
            //async: false,
            cache: false,
            contentType: false,
            processData: false,
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
