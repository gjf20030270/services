<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>vendor</title>
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
<div class="container" id="vendor">
    <div style="padding-top: 30px;" >
     <!-- toolbar-->
    <div id="vendorToolbar" class="btn-group">
        <button type="button" class="btn btn-default" id="saveVendor">
                <i class="glyphicon glyphicon-plus"></i>
        </button>
     </div>

    <!-- table list-->
    <table id="vendorTable" data-toolbar="#vendorToolbar" data-height="550" data-show-toggle="true" data-show-columns="false" data-striped="true"></table>

    <!-- edit modal-->
    <div id="editVendorModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
         <div class="modal-dialog" role="document">
             <div class="modal-content" id="content">
               <div class="modal-header">
                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="exampleModalLabel">供应商信息维护</h4>
                </div>
                <div class="modal-body" id="editBody">
                    <form id="saveVendorForm" class="form-horizontal" role="form">
                        <table class="table table-striped table-bordered table-hover">
                            <tr><div ><input type="text" id="id" name="id" hidden="hidden" value="-1"></div>
                                <td>服务商编码</td><td><input type="text" id="code" name="code" value=""/></td>
                                <td>服务商名</td><td><input type="text" id="name" name="name" value=""/></td>
                                <td>服务类型</td><td><input type="text" id="serviceType" name="serviceType" value=""/></td>
                            </tr>
                            <tr><td>请求参数</td><td colspan="5" ><input id="reqparamMap" name="reqparamMap"  value=""style="width: 100%"/></td>
                            </tr>
                            <tr><td>请求Url</td><td colspan="3"><input type="text" id="requestUrl" name="requestUrl" value="" style="width: 100%"/></td>
                                <td>超时时间</td><td><input type="text" id="requestTimeOut" name="requestTimeOut" value=""/></td>
                            </tr>
                            <tr><td>请求方法</td><td><input type="text" id="requestMethod" name="requestMethod" value=""/></td>
                                <td>回调方式</td><td><input type="text" id="notifyType" name="notifyType" value=""/></td>
                                <td>服务优先级</td><td><input type="text" id="level" name="level" value=""/></td>
                            </tr>
                            <tr><td>回调URL</td><td colspan="3"><input type="text" id="callbackUrl" name="callbackUrl" value="" style="width: 100%"/></td>
                                <td>服务商公司电话</td><td><input type="text" id="companyPhone" name="companyPhone" value=""/></td>
                            </tr>
                            <tr><td>开始时间</td><td>
                                                    <div class="input-append date form_datetime" id="date-start">
                                                        <input readonly size="16" type="text" id="serviceStartTime" name="serviceStartTime" size="16" value="">
                                                        <span class="add-on"><i class="icon-remove"></i></span>
                                                        <span class="add-on"><i class="icon-calendar"></i></span>
                                                    </div>
                                                </td>
                                <td>结束时间</td><td>
                                                    <div class="input-append date form_datetime" id="date-end">
                                                        <input readonly size="16" type="text" id="serviceStopTime" name="serviceStopTime" value=""/>
                                                        <span class="add-on"><i class="icon-remove"></i></span>
                                                        <span class="add-on"><i class="icon-calendar"></i></span>
                                                    </div>
                                                </td>
                                <td>数据是否有效</td><td><input id="stateY" name="status" type="radio" value="1"/> 启用
                                                        <input id="stateN" name="status" type="radio" value="0"/> 停用</td>
                            </tr>
                            <tr><td>服务商联系人电话</td><td><input type="text" id="contactsPhone" name="contactsPhone" value=""/></td>
                                <td>服务商联系人</td><td><input type="text" id="contactsName" name="contactsName" value=""/></td>
                                <td>结算方式</td><td><input type="text" id="settlementType" name="settlementType" value=""/></td>
                                </tr>
                            <tr><td>收费标准</td><td><input type="text" id="chargeBasic" name="chargeBasic" value=""/></td>
                                <td>服务商汇款账号</td><td><input type="text" id="account" name="account" value=""/></td>
                                <td>缓存时间</td><td><input type="text" id="cacheTime" name="cacheTime" value=""/></td>
                                </tr>
                            <tr><td>appKey</td><td colspan="2"><input type="text" id="appKey" style="width: 100%" name="appKey" value=""/></td>
                                <td>appSecret</td><td colspan="2"><input type="text" id="appSecret" style="width: 100%" name="appSecret" value=""/></td>
                                </tr>
                            <tr><td>备注</td><td colspan="5"><input type="text" id="remark" style="width: 100%" name="remark" value=""/></td>
                            </tr>
                            </table>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="reset" name="reset" style="display: none;" />
                                <button type="button" class="btn btn-primary" onclick="saveData();">Save</button>
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
        $(".form_datetime").datetimepicker({
            todayBtn: true,
            pickerPosition: "bottom-left",
            format: 'yyyy-mm-dd hh:ii',
            autoclose:true//自动关闭
        });

        $("#saveVendor").on('click', function () {
            $("#editVendorModal").modal('show');
            $($("[name='status']")[0]).prop("checked","checked");
        });
        $("#cancel").on('click', function () {
            $("input[type=reset]").trigger("click");
            $($("[name='status']")).prop("checked","false");
        });
        $(".close").on('click', function () {
            $("input[type=reset]").trigger("click");
            $($("[name='status']")).prop("checked","false");
        });

//        dataValidator();
    });
    //初始化列表数据
    $('#vendorTable').bootstrapTable({
        pagination: true, //开启分页
        search: true,
        pagination:true,
        showRefresh: true, // 开启刷新功能
        url: '/vendor/vendorInfo.json',
        columns: [{
            field: 'id',
            title: '主键',
            sortable: true
        }, {
            field: 'code',
            title: '服务商编码'
        }, {
            field: 'name',
            title: '服务商名',
            sortable: true
        }, {
            field: 'serviceType',
            title: '服务类型',
            sortable: true
        }, {
            field: 'reqparamMap',
            title: '请求参数'
        }, {
            field: 'requestUrl',
            title: '请求Url'
        }, {
            field: 'requestTimeOut',
            title: '超时时间',
            sortable: true
        }, {
            field: 'requestMethod',
            title: '请求方法'
        }, {
            field: 'callbackUrl',
            title: '回调URL'
        }, {
            field: 'notifyType',
            title: '回调方式',
            sortable: true
        }, {
            field: 'level',
            title: '服务优先级',
            sortable: true
        }, {
            field: 'serviceStartTime',
            title: '开始时间',
            sortable: true
        }, {
            field: 'serviceStopTime',
            title: '结束时间',
            sortable: true
        }, {
            field: 'createTime',
            title: '创建时间',
            hide:true,
            sortable: true
        }, {
            field: 'updateTime',
            title: '修改时间',
            sortable: true
        }, {
            field: 'companyPhone',
            title: '服务商公司电话',
            sortable: true
        }, {
            field: 'contactsPhone',
            title: '服务商联系人电话'
        }, {
            field: 'contactsName',
            title: '服务商联系人'
        }, {
            field: 'account',
            title: '服务商汇款账号',
            sortable: true
        }, {
            field: 'settlementType',
            title: '结算方式',
            sortable: true
        }, {
            field: 'chargeBasic',
            title: '收费标准',
            sortable: true
        }, {
            field: 'status',
            title: '服务商状态',
            formatter: function (value, row, index) {
                if (value == 1)  return '启用';
                else return '停用';
            },
            sortable: true
        }, {
            field: 'appKey',
            title: 'appKey'
        }, {
            field: 'appSecret',
            title: 'appSecret'
        }, {
            field: 'cacheTime',
            title: '缓存时间',
            sortable: true
        },{
            field: 'remark',
            title: '备注'
        },{
            field: 'id',
            title: '编辑/删除',
            formatter: function (value, row, index) {
                var str='<div with="500px"><a class="edit ml10" href="javascript:void(0)" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>' +
                        '<a class="remove ml10" href="javascript:void(0)" title="Remove"><i class="glyphicon glyphicon-remove"></i></a></div>';
                return [str].join('');

            },
            events:window.actionEvents = {
                'click .edit': function (e, value, row, index) {
                    $('#editVendorModal').modal('show');
                    initEditDate(row);
                },
                'click .remove': function (e, value, row, index) {
                    if (confirm("You sure remove it?")) {
                        $.ajax({
                            type: "POST",
                            url:"/vendor/deleteVendor",
                            data: {id: row.id},
                            async: true,
                            dataType:"json",
                            success : function(data) {
                                data = JSON.parse(data);
                                if (data.resCode == 1) {
                                    alert("Data Removed Success");
                                    $('#vendorTable').bootstrapTable('refresh');
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

    //隐藏部分列
    $(function(){
        $('#vendorTable').bootstrapTable('hideColumn', 'id');
//        $('#vendorTable').bootstrapTable('hideColumn', 'reqparamMap');
//        $('#vendorTable').bootstrapTable('hideColumn', 'requestUrl');
//        $('#vendorTable').bootstrapTable('hideColumn', 'createTime');
//        $('#vendorTable').bootstrapTable('hideColumn', 'updateTime');
//        $('#vendorTable').bootstrapTable('hideColumn', 'requestTimeOut');
//        $('#vendorTable').bootstrapTable('hideColumn', 'companyPhone');
//        $('#vendorTable').bootstrapTable('hideColumn', 'contactsPhone');
//        $('#vendorTable').bootstrapTable('hideColumn', 'notifyType');
//        $('#vendorTable').bootstrapTable('hideColumn', 'callbackUrl');
//        $('#vendorTable').bootstrapTable('hideColumn', 'companyPhone');
//        $('#vendorTable').bootstrapTable('hideColumn', 'contactsPhone');
//        $('#vendorTable').bootstrapTable('hideColumn', 'remark');
//        $('#vendorTable').bootstrapTable('hideColumn', 'serviceStartTime');
//        $('#vendorTable').bootstrapTable('hideColumn', 'serviceStopTime');
//        $('#vendorTable').bootstrapTable('hideColumn', 'cacheTime');
    });
    //初始化修改数据
    function initEditDate(row){
        $('.form-horizontal #id').val(row.id);
        $('.form-horizontal #code').val(row.code);
        $('.form-horizontal #name').val(row.name);
        $('.form-horizontal #serviceType').val(row.serviceType);
        $('.form-horizontal #reqparamMap').val(row.reqparamMap);
        $('.form-horizontal #requestUrl').val(row.requestUrl);
        $('.form-horizontal #requestTimeOut').val(row.requestTimeOut);
        $('.form-horizontal #requestTimeOut').val(row.requestTimeOut);
        $('.form-horizontal #requestMethod').val(row.requestMethod);
        $('.form-horizontal #notifyType').val(row.notifyType);
        $('.form-horizontal #level').val(row.level);
        $('.form-horizontal #callbackUrl').val(row.callbackUrl);
        $('.form-horizontal #serviceStartTime').val(row.serviceStartTime,'yyyy-mm-dd');
        $('.form-horizontal #serviceStopTime').val(row.serviceStopTime,'yyyy-mm-dd');
        $('.form-horizontal #companyPhone').val(row.companyPhone);
        $("input:radio[name='status'][value="+row.status+"]").prop("checked","checked");
        $('.form-horizontal #contactsPhone').val(row.contactsPhone);
        $('.form-horizontal #contactsName').val(row.contactsName);
        $('.form-horizontal #settlementType').val(row.settlementType);
        $('.form-horizontal #chargeBasic').val(row.chargeBasic);
        $('.form-horizontal #account').val(row.account);
        $('.form-horizontal #appKey').val(row.appKey);
        $('.form-horizontal #appSecret').val(row.appSecret);
        $('.form-horizontal #remark').val(row.remark);
        $('.form-horizontal #cacheTime').val(row.cacheTime);


    }

    function saveData(){
        $.ajax({
            cache: true,
            type: "POST",
            url:"/vendor/optVendor",
            data:$('#saveVendorForm').serialize(),// formid
            async: false,
            dataType:"json",
            success : function(data) {
                data = JSON.parse(data);
                $("input[type=reset]").trigger("click");
                $($("[name='status']")).prop("checked","false");
                if(data.resCode == 1){
                    $('#editVendorModal').modal('hide');
                    $('#vendorTable').bootstrapTable('refresh');
                }else{
                    $('#editVendorModal').modal('hide');
                    alert("Data Save Error");
                }
            }
        });
    }


    function dataValidator(){
        $('#saveVendorForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                name: {
                    message: '用户名验证失败',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: '用户名长度必须在6到18位之间'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '用户名只能包含大写、小写、数字和下划线'
                        }
                    }
                }
             }
        });
    }
</script>
</body>
</html>
