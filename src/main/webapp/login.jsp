<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!doctype html>
<html>
<head>
    <link rel="shortcut icon" href="${ctx}/static/images/icon.png">
    <link rel="stylesheet" href="${ctx}/static/css/login/login.css">
    <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/jquery.md5.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/login.js"></script>
    <title>沃音乐数据展示平台</title>
</head>
<body>
<div id="login_center">
    <div id="login_area">

        <div id="login_form" style="top: 80px; height: 223px; left: 423px;">
            <div style="font-size: 30px;color: #DB2708;font-weight: bold;" align="center">
                沃音乐数据展示平台
            </div>
            <form action="${ctx}/auth/login.do" method="post" name="loginForm" id="loginForm">
                <div id="login_tip">
                    用户登录&nbsp;&nbsp;UserLogin
                </div>
                <div align="center" style="color:red" id="error"></div>
                <div>
                    <input type="text" id="loginName" name="username" class="username">
                </div>
                <div>
                    <input type="password" id="password" name="password" class="pwd">
                </div>
                <div id="btn_area">
                    <input type="button" name="loginBt" id="sub_btn" onclick="login();" value="登录">
                    &nbsp;&nbsp;
                </div>
            </form>
        </div>
    </div>
</div>
<div id="login_bottom" style="margin-top: 50px;">
    版权所属：中国联通音乐运营中心
</div>
</body>
</html>