<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>DB_SHOW -- 数据查询</title>
    <link rel="shortcut icon" href="${ctx}/static/images/icon.png">
    <link href="${ctx}/static/css/css.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/nav_css.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/common.js"></script>
</head>
<body>
<div>
    <s:if test="#request.size gt 0">
        <table class="table_jieg" cellspacing="0" style="width: 100%;">
            <tr style="height: 35px;">
                <s:iterator id="lab" value="%{#request.labels}">
                    <th>${lab.value}</th>
                </s:iterator>
            </tr>
            <s:iterator id="list" value="%{#request.datas}">
                <tr style="height: 35px;" onMouseOver="this.style.backgroundColor = '#EBF2F9'"
                    onMouseOut="this.style.backgroundColor = ''">
                    <s:iterator id="data" value="list">
                        <td>${data.value}</td>
                    </s:iterator>
                </tr>
            </s:iterator>
        </table>
    </s:if>
</div>
</body>
</html>
