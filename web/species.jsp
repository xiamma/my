<%--
  Created by IntelliJ IDEA.
  User: love
  Date: 2020/12/31
  Time: 下午5:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>种类管理</title>
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
                <h3 class="panel-title">种类管理面板</h3>
            </div>
            <div class="panel-body">

                <div id="toolbar">
                    <button class="btn btn-primary" onclick="addSpecies()"><span class="glyphicon glyphicon-plus"></span> 新增</button>
                </div>


                <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="myModal">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">修改种类</h4>
                            </div>
                            <div class="modal-body">
                                <form action="" class="form-horizontal">

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">种类名</label>
                                        <div class="col-sm-9">
                                            <input type="hidden" class="form-control" id="id">
                                            <input   type="text" class="form-control" id="ename">

                                        </div>
                                    </div>

                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary" id="save-edit-btn">保存</button>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="addUserModal" id="addSpeciesModal">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">新增种类</h4>
                            </div>
                            <div class="modal-body">
                                <form action="" class="form-horizontal">

                                    <div class="form-group">
                                        <label  class="col-sm-2 control-label">种类名</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="name">
                                        </div>
                                    </div>

                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary" id="save-add-btn">保存</button>
                            </div>
                        </div>
                    </div>
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
        url: 'speciesQuery',        // 表格数据来源
        classes: "table table-bordered table-hover text-info ",//这里设置表头样式
        search: true,
        showHeader : true,
        showColumns : true,
        showRefresh : false,
        pagination: true,//分页
        sidePagination : 'client',//服务器端分页
        pageNumber : 1,
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
            title: '种类名',
            halign:'center',
            align:'center'
        },{
            field: '',
            title: '操作',
            halign:'center',
            align:'center',
            width:'320px',
            formatter: function (value, row, index) {

                return "<button class=\"btn btn-primary\" onclick=\"editSpecies('"+ encodeURI(JSON.stringify(row)) +"')\">修改</button>" +
                    '<button style="margin-left: 10px" class="btn btn-danger" onclick="deleteSpecies('+row.id+')">删除</button>'

            }
        }

        ]
    });


    function editSpecies(row) {

        row = decodeURI(row);
        row = eval("("+row+")");

        $("#ename").val(row.name)
        $("#id").attr("value", row.id);

        // 打开模态框
        $('#myModal').modal('show');
    }

    function addSpecies() {
        // 清空input框
        $("#name").val("")
        $('#addSpeciesModal').modal('show');
    }

    function deleteSpecies(id) {
        //询问框
        layer.confirm('确定要删除id为：'+id+'的种类吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $.ajax({
                type: "post",
                url: "speciesDelete",
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



    $("#save-add-btn").click(function () {
        var name = $("#name").val();
        if(name == null || name == "") {
            layer.msg("种类名不能为空哦！", {icon: 2})
            return
        }

        $.ajax({
            type: "post",
            url: "speciesAdd",
            dataType:"json",
            data: {
                name,
            },
            success:function(data){
                if(data.status == 200) {
                    layer.msg(data.msg, {icon: 1});
                    // 关闭模态框
                    $('#addSpeciesModal').modal('hide');
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
        var name = $("#ename").val();
        var id = $("#id").val()

        if(name == "") {
            layer.msg("种类名不能为空哦！", {icon: 2})
            return
        }


        $.ajax({
            type: "post",
            url: "speciesUpdate",
            dataType:"json",
            data: {
                name,
                id
            },
            success:function(data){
                console.log(data)
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

</script>