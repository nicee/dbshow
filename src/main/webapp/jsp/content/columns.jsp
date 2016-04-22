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
<div class="user_result_new">
    <table class="table_jieg" cellspacing="0" style="width: 100%;">
        <tr style="height: 35px;">
            <th>表名称</th>
            <th>操作</th>
        </tr>
        <s:if test="#request.size gt 0">
        <s:iterator id="table" value="%{#request.tables}">
            <tr style="height: 35px;" onMouseOver="this.style.backgroundColor = '#EBF2F9'"
                onMouseOut="this.style.backgroundColor = ''">
                <td>${table}</td>
                <td>
                    <a href="#" onclick="config('${table}')">配置</a>
                </td>
            </tr>
        </s:iterator>
    </table>
    </s:if>
    <s:else>
        </table>
        <div>无可用数据库操作</div>
    </s:else>
</div>
<script type="text/javascript">
    function config(name) {
        parent.frames.funcIframe[0].src = '/column/columns.do?table_name=' + name;
    }
</script>
</body>
</html>