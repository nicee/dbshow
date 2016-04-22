<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="${ctx}/static/images/icon.png">
    <link href="${ctx}/static/css/css.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/style.css" type="text/css" rel="stylesheet"/>
    <link href="${ctx}/static/css/nav_css.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" href="${ctx}/static/js/zTreeStyle.css" type="text/css"/>
    <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/jquery.ztree.core-3.5.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/iframe.js"></script>
    <style>
        body {
            margin: 0;
            padding: 0;
        }

        div, p, table, th, td {
            list-style: none;
            margin: 0;
            padding: 0;
            color: #333;
            font-size: 12px;
            font-family: dotum, Verdana, Arial, Helvetica, AppleGothic, sans-serif;
        }

        #funcIframe {
            margin-left: 10px;
        }
    </style>
    <title>沃音乐数据展示平台</title>
</head>
<jsp:include page="/title.jsp"/>
<body>
<div class="user_result_new">
    <div class="form_title" align="left">系统管理->功能管理</div>
    <TABLE border="0" align="left" width="100%">
        <TR>
            <TD width="25%" align="left" valign="top" style="BORDER: #999999 1px dashed;">
                <ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
            </TD>
            <TD width="75%" align="left" valign="top">
                <IFRAME ID="funcIframe" Name="funcIframe" FRAMEBORDER=0 SCROLLING=NO width=99% height=550px
                        SRC=""></IFRAME>
            </TD>
        </TR>
    </TABLE>
</div>
</body>
</html>