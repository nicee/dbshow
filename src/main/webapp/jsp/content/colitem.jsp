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
    <script type="text/javascript" src="${ctx}/static/js/dbshow/columns.js"></script>
</head>
<body>
<div style="margin:10px 0;text-align: center;font-weight: bold;font-size: 14px;">
    -- ${requestScope.table} --
</div>

<div class="user_result_new">
    <table class="table_jieg" cellspacing="0" style="width: 100%;">
        <tr style="height: 35px;">
            <th></th>
            <th style="width:30%;">列字段名</th>
            <th style="width:40%;">列备注名</th>
            <th style="width:20%;">状态</th>
        </tr>
        <s:if test="#request.size gt 0">
            <s:iterator id="column" value="%{#request.columns}">
                <tr style="height: 35px;" onMouseOver="this.style.backgroundColor = '#EBF2F9'"
                    onMouseOut="this.style.backgroundColor = ''">
                    <td><input type="checkbox" style="margin-left: 5px;" name="ids" value="${column.id}"
                               <s:if test="#column.active">checked</s:if>/></td>
                    <td><span name="column">${column.columnName}</span></td>
                    <td><input type="text" name="label" value="${column.labelName}"/></td>
                    <s:if test="#column.active">
                        <td style="color: green;">可查询</td>
                    </s:if>
                    <s:else>
                        <td style="color: red;">未查询</td>
                    </s:else>
                </tr>
            </s:iterator>
        </s:if>
    </table>
</div>
<div style="position: relative;float: right;top: 10px;right: 5px;padding: 10px;">
    <input type="button" class="an_ye" value="应用" onclick="choose('${requestScope.table}');"/>
</div>
</body>
</html>