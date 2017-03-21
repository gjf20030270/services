<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>access</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%@ include file="include/static.jsp"%>
    <%--<script type="text/javascript" src="/static/js/total.js" charset="utf-8"></script>--%>
</head>
<body>
<div class="container" id="access">
    <div class="alert alert-success" role="alert"></div>
    <div id="accountToolbar" class="btn-group">
        <button type="button" class="btn btn-default" id="query">
            <i class="glyphicon">访问统计</i>
        </button>
    </div>
    <!-- table list-->
    <table id="accessTable" data-toolbar="#accountToolbar"data-height="550" data-show-toggle="true" data-show-columns="true" data-striped="true"></table>
    <!-- edit modal-->
    <div id="queryTotalModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="exampleModalLabel">访问统计</h4>
                </div>
                <div class="modal-body" >
                        <table class="table table-striped table-bordered table-hover">
                            <tr>
                                <th>调用渠道</td>
                                <th>调用次数</td>
                            </tr>
                            <tbody id="datas">
                            </tbody>
                        </table>
                </div>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#query").on('click', function () {
            $("#queryTotalModal").modal('show');
            $.ajax({
                type: "POST",
                url: "/access/accesstotal.json",
                async: true,
                dataType: "json",
                success: function (data) {
                    data = JSON.parse(data);
                    if (data.resCode == 1) {
                        var str = "";
                        for(var i=0;i < data.data.length;i++){
                            str= $('<tr><td>'+data.data[i].canal+'</td><td>'+data.data[i].total+'</td></tr>');
                        }
                        $("#datas").append(str);
                    }
                }
            });
        });
//        $(".close").on('click', function () {
//            $("input[type=reset]").trigger("click");
//        });
    });
    //初始化列表数据
    $('#accessTable').bootstrapTable({
        pagination: true, //开启分页
        search: true,
        pagination:true,
        showRefresh: true, // 开启刷新功能
//        sortOrder: "id asc",
        url: '/access/accessInfo.json',

        columns: [{
            field: 'id',
            title: '主键',
            sortable: true
        }, {
            field: 'channel',
            title: '渠道',
            sortable: true
        }, {
            field: 'appKey',
            title: 'appKey',
            sortable: true
        }, {
            field: 'busiCode',
            title: '业务代码',
            sortable: true
        }, {
            field: 'vendorCode',
            title: '服务商编码',
            sortable: true
        }, {
            field: 'identifyCode',
            title: '服务的唯一码',
            sortable: true
        },{
            field: 'thirdIdentifyId',
            title: '服务回调唯一标志',
            sortable: true
        },{
            field: 'callbackTime',
            title: '回调时间',
            sortable: true
        },{
            field: 'requestParam',
            title: '请求参数'
        },{
            field: 'thirdRequestParam',
            title: '第三方请求参数'
        },{
            field: 'responResult',
            title: '响应结果'
        },{
            field: 'thirdResponResult',
            title: '第三方响应结果'
        },{
            field: 'status',
            title: '状态',
            formatter: function (value, row, index) {
                if (value == 1)  return '有效';
                else return '无效';
            },
            sortable: true
        }]
    });
    //隐藏部分列
    $(function(){
        $('#accessTable').bootstrapTable('hideColumn', 'id');
        $('#accessTable').bootstrapTable('hideColumn', 'requestParam');
        $('#accessTable').bootstrapTable('hideColumn', 'thirdRequestParam');
        $('#accessTable').bootstrapTable('hideColumn', 'responResult');
        $('#accessTable').bootstrapTable('hideColumn', 'thirdResponResult');
    });
    $("#access").find(".keep-open").on(){

    }
</script>
</body>
</html>
