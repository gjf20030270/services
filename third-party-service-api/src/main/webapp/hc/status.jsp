<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="com.cheyipai.platformservice.thirdparty.impl.ThirdPartyServiceCacheImpl" %>
<%@ page import="com.cheyipai.platformservice.thirdparty.bean.Chain" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.cheyipai.platformservice.thirdparty.entity.ServiceVendorDb" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cheyipai.platformservice.thirdparty.ThirdPartyService" %>
<%@ page import="java.util.ArrayList" %>
<%
    ThirdPartyServiceCacheImpl cache = ((ThirdPartyServiceCacheImpl) ThirdPartyServiceCacheImpl.getInstance());
    Map<String, Chain> map = cache.getThirdPartyServiceChainMap();
    out.println("<font color=\"red\">供应商db</font>");
    out.println(getVendorDataTable(cache.serviceVendorDbs));
    out.println("</br> <font color=\"red\">组合chain数据</font>");
    out.println(getChainDataTable(map));
%>
<%!
    public String getVendorDataTable(List<ServiceVendorDb> serviceVendorDbs) {
        return "<table width='100%' border='1' style='table-layout:fixed'>"
                +
                getVendorTableHeadData()
                +
                getVendorTableData(serviceVendorDbs)
                +
                "</table> <br/>";
    }

    public String getChainDataTable(Map<String, Chain> map) {


        return "<table width='100%' border='1' style='table-layout:fixed'>"
                +
                getChainTableHeadData()
                +
                getChainElementTableData(map)
                +
                "</table> <br/>";
    }

    public String getVendorTableHeadData() {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        sb.append("<td style='word-wrap:break-word'>供应商Id</td>");
        sb.append("<td style='word-wrap:break-word'>供应商code</td>");
        sb.append("<td style='word-wrap:break-word'>供应商level</td>");
        sb.append("<td style='word-wrap:break-word'>供应商名称</td>");
        sb.append("<td style='word-wrap:break-word'>供应商service-type</td>");
        sb.append("<td style=\"word-wrap:break-word\">创建时间</td>");
        sb.append("<td style=\"word-wrap:break-word\">url</td>");
        sb.append("</tr>");
        return sb.toString();
    }

    public String getChainTableHeadData() {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        sb.append("<td style='word-wrap:break-word'>key(serviceType)</td>");
        sb.append("<td style='word-wrap:break-word'>元素(element)</td>");
        sb.append("</tr>");
        return sb.toString();
    }

    public String getVendorTableData(List<ServiceVendorDb> serviceVendorDbs) {
        StringBuilder sb = new StringBuilder();
        for (ServiceVendorDb serviceVendorDb : serviceVendorDbs) {
            sb.append("<tr>");
            sb.append("<td style='word-wrap:break-word'>" + serviceVendorDb.getId() + "</td>");
            sb.append("<td style='word-wrap:break-word'>" + serviceVendorDb.getCode() + "</td>");
            sb.append("<td style='word-wrap:break-word'>" + serviceVendorDb.getLevel() + "</td>");
            sb.append("<td style='word-wrap:break-word'>" + serviceVendorDb.getName() + "</td>");
            sb.append("<td style='word-wrap:break-word'>" + serviceVendorDb.getServiceType() + "</td>");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sb.append("<td style='word-wrap:break-word'>" + sdf.format(serviceVendorDb.getCreateTime()) + "</td>");
            sb.append("<td style='word-wrap:break-word'>" + serviceVendorDb.getRequestUrl() + "</td>");
            sb.append("</tr>");
        }
        return sb.toString();
    }


    public String getChainElementTableData(Map<String, Chain> map) {

        StringBuilder sb = new StringBuilder();
        List<ServiceVendorDb> serviceVendorDbs = new ArrayList<ServiceVendorDb>();

        for (Map.Entry<String, Chain> entry :map.entrySet()) {
            sb.append("<tr>");
            sb.append("<td style='word-wrap:break-word'>" + entry.getKey()+ "</td>");
            sb.append("<td style='word-wrap:break-word'>");

            for(ThirdPartyService thirdPartyService :entry.getValue().getChainElements()) {
                thirdPartyService.getServiceVendorDb();
                serviceVendorDbs.add(thirdPartyService.getServiceVendorDb());
            }
            String a = getVendorDataTable(serviceVendorDbs);
            sb.append(a);
            sb.append("</td>");
            sb.append("</tr>");
        }

        return sb.toString();
    }
%>
