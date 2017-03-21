<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="application/javascript">

    function loadData(url,tabId,tabName){
        var existsTab = document.getElementById('tab_'+tabId);
        if(existsTab!=null){
            $('#myTab a[href="#tab_'+tabId+'"]').tab('show')
            return;
        }
        $.ajax({
            url:url,
            type:"GET",
            success:function(data){
                var tab = $('<li class=""><a href="#tab_'+tabId+'" data-toggle="tab">'+tabName+'<button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button></a></li>');
                $("#myTab").append(tab);
                var tabContent = $('<div class="tab-pane" id="tab_'+tabId+'"></div>');
                tabContent.append(data);
                $("#myTabContent").append(tabContent);
                $("#myTab li:last a").tab('show');
            }
        });

    }
</script>
<aside class="main-sidebar">
    <section class="sidebar">
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/img/user.png" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>欢迎</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <ul class="sidebar-menu">


            <c:forEach var="menu" items="${rootMenu.children}">
                <li class="treeview">
                    <a href="javascript:void(0)">
                        <i class="fa fa-link"></i>

                        <span><a href="javascript:void(0)"  tabid="${menu.id}" name="${menu.name}" onclick="loadData('${menu.url}','${menu.id}','${menu.name}')">${menu.name}
                        <%--<span>${menu.name}--%>
                        </span>
                        <span class="pull-right-container">
                          <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <c:forEach var="child" items="${menu.children}">
                            <li><a href="javascript:void(0)"  tabid="${child.id}" name="${child.name}" onclick="loadData('${child.url}','${child.id}','${child.name}')">${child.name}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ul>
    </section>
</aside>