<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>account</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%@ include file="include/static.jsp"%>
</head>
 <style type="text/css">
         .ml10 {
             margin-left: 10px;
         }
         .modal-dialog {
             width: 1030px;
             margin: 30px auto;
         }
  </style>
<body>
<div class="container" id="account">
    <div style="padding-top: 30px;" ></div>
     <!-- toolbar-->
    <div id="accountToolbar" class="btn-group">
        <button type="button" class="btn btn-default" id="save">
                <i class="glyphicon glyphicon-plus"></i>
        </button>
     </div>

    <!-- table list-->
    <table id="accountTable" data-toolbar="#accountToolbar" data-height="550" data-show-toggle="true" data-show-columns="false" data-striped="true"></table>

    <!-- edit modal-->
    <div id="editAccountModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
         <div class="modal-dialog" role="document">
             <div class="modal-content" id="content">
               <div class="modal-header">
                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="exampleModalLabel">账户授权</h4>
                </div>
                <div class="modal-body" id="editBody">
                    <form id="saveAccountForm" class="form-horizontal" role="form">
                            <table class="table table-striped table-bordered table-hover">
                                <tr><input id="id" name="id" value="-1" hidden>
                                    <td>业务编码</td>
                                    <td><input id="busiCode" name="busiCode" type="text"></td>
                                    <td>调用渠道</td>
                                    <td colspan="3"><input id="channel" name="channel" type="text"></td>
                                </tr>
                                <tr><td>账户名</td>
                                    <td ><input id="name" name="name" type="text"></td>
                                    <td>数据是否有效</td>
                                    <td colspan="3"><input id="stateY" name="state" type="radio" value=1 checked/> 有效
                                                    <input id="stateN" name="state" type="radio" value=0 /> 无效
                                    </td>
                                </tr>
                                <tr><td>详细描述</td>
                                    <td colspan="5"><input id="description" name="description" class="form-control" style="width: 100%"/></td>
                                </tr>
                            </table>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <input type="reset" name="reset" style="display: none;" />
                                    <button type="submit" class="btn btn-primary" onclick="saveData();">Save</button>
                                    <button type="button" id="cancel" class="btn btn-default" data-dismiss="modal" >Cancel</button>
                                    </div>
                            </div>
                        </form>

                </div>
            </div>
        </div>
     </div>

</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#save").on('click', function () {
            $("#editAccountModal").modal('show');
            $($("[name='state']")[0]).prop("checked","checked");
        });
        $("#cancel").on('click', function () {
            $("input[type=reset]").trigger("click");
            $($("[name='state']")).prop("checked","false");
        });
        $(".close").on('click', function () {
            $("input[type=reset]").trigger("click");
            $($("[name='state']")).prop("checked","false");
        });
//        dataValidator();
    });
    //初始化列表数据
    $(function(){
        $('#accountTable').bootstrapTable({
            pagination: true, //开启分页
            search: true,
            showRefresh: true, // 开启刷新功能
            url: '/account/accountInfo.json',
            columns: [{
                field: 'id',
                title: '主键',
                sortable: true
            }, {
                field: 'appKey',
                title: 'AppKey'
            }, {
                field: 'appSecret',
                title: 'AppSecret'
            }, {
                field: 'name',
                title: '名称',
                sortable: true
            }, {
                field: 'description',
                title: '详情描述'
            }, {
                field: 'state',
                title: '是否有效',
                formatter: function (value, row, index) {
                    if (value == 1)  return '有效';
                    else return '无效';
                },
                sortable: true
            },{
                field: 'id',
                title: '编辑/删除',
                width:'94px',
                formatter: function (value, row, index) {
                    var str='<a class="edit ml10" href="javascript:void(0)" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>' +
                            '<a class="remove ml10" href="javascript:void(0)" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>';
                    return [str].join('');

                },
                events:window.actionEvents = {
                    'click .edit': function (e, value, row, index) {
                        $('#editAccountModal').modal('show');
                        initEditDate(row);
                    },
                    'click .remove': function (e, value, row, index) {
                        if (confirm("You sure remove it?")) {
                            $.ajax({
                                type: "POST",
                                url:"/account/deleteAccount",
                                data: {id: row.id},
                                async: true,
                                dataType:"json",
                                success : function(data) {
                                    data = JSON.parse(data);
                                    if (data.resCode == 1) {
                                        alert("Data Removed Success");
                                        $('#accountTable').bootstrapTable('refresh');
                                    } else {
                                        alert("Data Removed Error");
                                    }
                                }
                            });
                        }
                    }
                }
            }
            ]
        });

        $('#accountTable').bootstrapTable('hideColumn', 'id');
//        $('#accountTable').bootstrapTable('hideColumn', 'description');
    });
    //初始化修改数据
    function initEditDate(row){
        $('.form-horizontal #id').val(row.id);
        $('.form-horizontal #busiCode').val(row.busiCode);
        $('.form-horizontal #channel').val(row.channel);
        $('.form-horizontal #name').val(row.name);
        $('.form-horizontal #description').val(row.description);
        $("input:radio[name='state'][value="+row.state+"]").prop("checked","checked");
    }

    function saveData(){
        $.ajax({
            cache: true,
            type: "POST",
            url:"/account/optAccount",
            data:$('#saveAccountForm').serialize(),// formid
            async: false,
            dataType:"json",
            success : function(data) {
                data = JSON.parse(data);
                $("input[type=reset]").trigger("click");
                $($("[name='state']")).prop("checked","false");
                if(data.resCode == 1){
                    $('#editAccountModal').modal('hide');
                    $('#accountTable').bootstrapTable('refresh');
                }else{
                    $('#editAccountModal').modal('hide');
                    alert("Data Save Error");
                }
            }
        });
    }


    function dataValidator(){
        $('#saveAccountForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                appSecret: {
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        }//,
//                        stringLength: {
//                            min: 6,
//                            max: 18,
//                            message: '用户名长度必须在6到18位之间'
//                        },
//                        regexp: {
//                            regexp: /^[a-zA-Z0-9_]+$/,
//                            message: '用户名只能包含大写、小写、数字和下划线'
//                        }
                    }
                }
            },
            submitHandler: function(validator, form, submitButton) {
                alert("submit");
            }
        });
    }
</script>
</body>
</html>
