<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: love
  Date: 2020/12/30
  Time: 下午7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>宠物管理</title>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="css\font-awesome.min.css"> -->
    <script src="assets/js/jquery-3.2.1.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>


    <link rel="stylesheet" href="assets/css/bootstrap-table.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="assets/js/bootstrap-table.min.js"></script>
    <!-- Latest compiled and minified Locales -->
<%--    <script src="assets/js/bootstrap-table-zh-CN.min.js"></script>--%>
    <script src="assets/layer/layer.js"></script>

</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">宠物管理面板</h3>
            </div>
            <div class="panel-body">

                <div id="toolbar">

                    <form class="form-inline">
                        <c:if test="${user.role == 2}">
                            <a class="btn  btn-primary" href="petAdd.jsp"><span class="glyphicon glyphicon-plus" ></span> 新增</a>
                        </c:if>

                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">种类</div>
                                <select class="form-control" name="sid" id="sid">
                                    <option value="">请选择</option>
                                    <option value="1">小猫</option>
                                    <option value="2">小狗</option>
                                    <option value="3">其他动物</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">是否绝育</div>
                                <select class="form-control" name="isJY" id="isJY">
                                    <option value="">请选择</option>
                                    <option value="1">是</option>
                                    <option value="2">否</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">是否购买</div>
                                <select class="form-control" name="isf" id="isf">
                                    <option value="" >请选择</option>
                                    <option value="1" >是</option>
                                    <option value="2" >否</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">宠物名</div>
                                <input type="text" class="form-control" name="name" id="name" placeholder="请输入宠物名">
                            </div>
                        </div>
                        <button type="button" id="searchBtn" class="btn btn-primary queryButton">查询</button>
                    </form>
                </div>
                <table id="table"></table>

            </div>
        </div>

    </div>
</div>
</body>
</body>
</html>
<script>


    $('#table').bootstrapTable({
        url: 'petQuery',        // 表格数据来源
        queryParams: function (params) {
            return {
                offset: params.offset,  // 页码
                limit: params.limit,    // 页面大小
                sid: $("#sid").val(),   // 种类
                isJY: $("#isJY").val(), // 是否绝育
                isf: $("#isf").val(),   // 是否领养
                name: $("#name").val()  // 宠物名
            };
        },
        classes: "table table-bordered table-hover text-info ",//这里设置表头样式
        search: false,
        showHeader : true,
        showColumns : true,
        showRefresh : false,
        pagination: true,//分页
        sidePagination : 'server',//服务器端分页
        pageNumber : 1,
        pageSize : 5,//单页记录数
        pageList: [5, 10, 20, 50],//分页步进值
        toolbar:'#toolbar',//工具栏
        toolbarAlign:'left',//工具栏的位置

        columns: [{
            field: 'id',
            title: 'ID',
            halign:'center',
            align:'center'

        }, {
            field: 'name',
            title: '宠物名',
            halign:'center',
            align:'center'

        }, {
            field: 'img',
            title: '宠物照片',
            halign:'center',
            align:'center',
            sortable: false,//启用排序
            formatter : function (value, row, index) {
                var template = '<img src="'+value+'"  width="80" height="80"/>'
                return template;
            }


        },{
            field: 'species',
            title: '种类',
            halign:'center',
            align:'center',

        },{
            field: 'character',
            title: '价钱',
            halign:'center',
            align:'center',
        },{
            field: 'isJY',
            title: '是否绝育',
            halign:'center',
            align:'center',
            formatter:function (value, row, index) {
                if(value == 1) {
                    return "是"
                }else if(value == 2){
                    return "否"
                }

                return "未知";
            }

        },{
            field: 'organization',
            title: '所属宠物店',
            halign:'center',
            align:'center',

        },{
            field: 'feeder',
            title: '饲主',
            halign:'center',
            align:'center',

        },{
            field: 'createTime',
            title: '注册时间',
            halign:'center',
            align:'center',
            formatter:function (value, row, index) {
                return value;
            }

        } ,{
            field: '',
            title: '操作',
            halign:'center',
            align:'center',
            width:'220px',
            formatter: function (value, row, index) {
                var btn1 = '<a class="btn btn-success " target="_blank"  href="petDetail?id='+row.id+'">查看</a>';
                var btn2 = '<a style="margin-left: 10px" class="btn btn-warning"  href="petUpdate?id='+row.id+'">修改</a>';
                var btn3 = '<button style="margin-left: 10px" class="btn btn-danger " onclick="deletePet('+row.id+')">删除</button>';
                var btn4 = '<a style="margin-left: 10px" class="btn btn-warning"  href="petEditor?id='+row.id+'">补充</a>';
                var btn5 = '<button style="margin-left: 10px" class="btn btn-danger " onclick="addFeeder('+row.id+')">购买</button>';

                var role = ${user.role};
                var id = ${user.id};

                if(role == 2) {
                    return btn1 + btn2 + btn3
                }else if(role == 3) {
                    if(row.feeder) {
                        if(row.fid == id) {
                            return btn1 + btn4
                        }else {
                            return btn1
                        }
                    }else {
                        return btn1  + btn5
                    }

                }else {
                    return btn1
                }


            }
        }

        ]
    });

    //获取分类列表
    $(document).ready(function () {
        var opt;
        $.get("speciesQuery","",function (data,status) {
            if(data){
                var rows = data.rows
                //循环读入数据并添加到院系列表中
                $.each(rows,function (i,item) {
                    opt="<option value="+item.id+">"+item.name+"</option>";

                    $("#sid").append(opt);
                })
            }
        });
    });


    function editUser(id) {

        // 清空input框
        $("#newPwd").val("")
        $("#id").attr("value", id);

        // 打开模态框
        $('#myModal').modal('show');
    }

    function addUser() {
        // 清空input框
        $("#username").val("")
        $("#password").val("")
        $('#addUserModal').modal('show');
    }

    function deleteUser(id) {
        //询问框
        layer.confirm('确定要删除id为：'+id+'的用户吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $.ajax({
                type: "post",
                url: "userDelete",
                dataType:"json",
                data: {
                    type: 'delete',
                    id
                },
                success:function(data){
                    if(data.status == 200) {
                        layer.msg(data.msg, {icon: 1});
                    }else {
                        layer.msg(data.msg, {icon: 2});
                    }

                    $('#table').bootstrapTable('refresh', {pageNumber:1});


                },
                error:function(jqXHR){
                    console.log("Erro")
                }
            });


        });
    }



    $("#save-add-btn").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        var role = $("#role").val()
        if(username == null || username == "") {
            layer.msg("用户名不能为空哦！", {icon: 2})
            return
        }
        if(password == null || password == "") {
            layer.msg("密码不能为空哦！！", {icon: 2})
            return
        }

        if(role == null || role == "") {
            layer.msg("请选择角色！！", {icon: 2})
            return
        }

        $.ajax({
            type: "post",
            url: "userAdd",
            dataType:"json",
            data: {
                type: 'add',
                username,
                password,
                role
            },
            success:function(data){
                if(data.status == 200) {
                    layer.msg(data.msg, {icon: 1});
                    // 关闭模态框
                    $('#addUserModal').modal('hide');
                    // 刷新表格
                    $('#table').bootstrapTable('refresh');
                }else {
                    layer.msg(data.msg, {icon: 2});
                }


            },
            error:function(jqXHR){
                console.log("Erro")
            }
        });
    })

    $("#save-edit-btn").click(function () {
        var newPwd = $("#newPwd").val();

        if(newPwd == "") {
            layer.msg("不能为空哦！", {icon: 2})
            return
        }


        var id = $("#id").val()

        $.ajax({
            type: "post",
            url: "userUpdate",
            dataType:"json",
            data: {
                type: 'update',
                newPwd,
                id
            },
            success:function(data){
                if(data.status == 200) {
                    layer.msg(data.msg, {icon: 1});
                    // 关闭模态框
                    $('#myModal').modal('hide');
                    // 刷新表格
                    $('#table').bootstrapTable('refresh');
                }else {
                    layer.msg(data.msg, {icon: 2});
                }
            },
            error:function(jqXHR){
                console.log("Erro")
            }
        });

    })



    // 购买
    function addFeeder(id) {

        layer.confirm('确定要购买id为：'+id+'的宠物吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $.ajax({
                type: "post",
                url: "petFeed",
                dataType:"json",
                data: {
                    id,
                },
                success:function(data){
                    if(data.status == 200) {
                        layer.msg(data.msg, {icon: 1});
                    }else {
                        layer.msg(data.msg, {icon: 2});
                    }

                    $('#table').bootstrapTable('refresh', {pageNumber:1});


                },
                error:function(jqXHR){
                    console.log("Erro")
                }
            });


        });
    }

    // 删除
    function deletePet(id) {
        layer.confirm('确定要删除id为：'+id+'的宠物吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $.ajax({
                type: "post",
                url: "petDelete",
                dataType:"json",
                data: {
                    id
                },
                success:function(data){
                    if(data.status == 200) {
                        layer.msg(data.msg, {icon: 1});
                    }else {
                        layer.msg(data.msg, {icon: 2});
                    }

                    $('#table').bootstrapTable('refresh', {pageNumber:1});

                },
                error:function(jqXHR){
                    console.log("Erro")
                }
            });


        });
    }

    // 条件查询
    $("#searchBtn").click(function () {
        $('#table').bootstrapTable('refresh');
    })


</script>