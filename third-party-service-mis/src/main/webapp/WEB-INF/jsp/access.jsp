<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
    <div style="padding-top: 30px;" ></div>
    <table id="query"class="table table-striped table-bordered table-hover" align="center">
        <tr> <td>访问渠道：</td><td><input id="channel" type="text" value=""/></td>
            <td>appKey：</td><td COLSPAN="3"><input id="appKey" type="text" style="width: 100%;" value=""/></td>
        </tr>
        <tr>
            <td>业务代码：</td><td><input id="busiCode" name="customerName4" type="text" value=""/></td>
            <td>服务商编码：</td><td><input id="vendorCode" name="customerName4" type="text" value=""/></td>
            <td>服务唯一码：</td><td><input id="identifyCode" name="identifyCode" type="text" value=""/></td>
        </tr>
        <tr>
            <td>回调时间：</td><td><input id="callbackTime" name="callbackTime" type="text" value=""/></td>
            <td>调用否有效：</td>
            <td><input id="statusY" name="status" type="radio" value=1 checked/> 有效
                <input id="statusN" name="status" type="radio" value=0 /> 无效</td>
            <td>数据请求：</td>
            <td><input id="all" name="thirdRequest" type="radio" value=1 checked/> 全部请求
                <input id="third" name="thirdRequest" type="radio" value=0 /> 第三方请求</td>
        </tr>
        <tr><td colspan="6" align="right"><button id="search" type="button">查询</button></td></tr>
    </table>
    <!-- table list-->
    <div style="padding-top: 30px;" >
    <table id="accessTable" data-height="550"data-show-columns="false" data-striped="true">

    </table>
    </div>

</div>
<script type="text/javascript">
    $(function () {
        tableInit();
        $("#search").bind("click", tableInit);
    });


    function tableInit(){
        $('#accessTable').bootstrapTable('destroy');
        $('#accessTable').bootstrapTable({
            url: '/access/accessInfo.json',         //请求后台的URL（*）
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
//            sortable: false,                     //是否启用排序
//            sortOrder: "asc",                   //排序方式
            queryParams: function queryParams(params) {
                var param = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
//                    limit: params.limit,   //页面大小
//                    offset: params.offset,  //页码
                    channel: $("#channel").val(),
                    appKey: $("#appKey").val(),
                    busiCode: $("#busiCode").val(),
                    vendorCode: $("#vendorCode").val(),
                    callbackTime: $("#callbackTime").val(),
                    thirdRequestParam:$('input:radio[name="thirdRequest"]:checked').val(),
//                    maxrows: params.limit,
//                    pageindex: params.pageNumber,
                    status: $('input:radio[name="status"]:checked').val()
                };
                return param;
            },//传递参数（*）
//            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
//            pageNumber:1,                       //初始化加载第一页，默认第一页
//            pageSize: 50,                       //每页的记录行数（*）
//            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
//            strictSearch: true,
//            cardView: false,                    //是否显示详细视图
//            detailView: false,                   //是否显示父子表
            columns: [{
                field: 'id',
                title: '序号'
            }, {
                field: 'channel',
                title: '渠道'
            }, {
                field: 'appKey',
                title: 'appKey'
            }, {
                field: 'busiCode',
                title: '业务代码'
            }, {
                field: 'vendorCode',
                title: '服务商编码'
            }, {
                field: 'identifyCode',
                title: '服务的唯一码'
            },{
                field: 'thirdIdentifyId',
                title: '服务回调唯一标志'
            },{
                field: 'callbackTime',
                title: '回调时间'
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
                }
            }]
        });
    }

</script>
</body>
</html>
