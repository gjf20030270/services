<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>access</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%@ include file="include/static.jsp"%>
</head>
<body>
<div class="container" id="access">
    <table id="total"></table>
    <div class="alert alert-success" role="alert"></div>
    <!-- table list-->
    <table id="accessTable" data-height="550" data-show-toggle="true" data-show-columns="true" data-striped="true"></table>
</div>
<script type="text/javascript">
    //初始统计列表数据
    $('#total').bootstrapTable({
        showRefresh: true, // 开启刷新功能
        url: '/access/accesstotal.json',
        columns: [{
            field: 'channel',
            title: '渠道'
        }, {
            field: 'id',
            title: '调用次数'
        }]
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
</script>
</body>
</html>
