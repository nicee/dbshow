<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2016/3/22
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSI-Login -- Product by Nicee</title>
</head>
<body>
<s:form action="/login.action" method="post">
    <s:label value="系统登陆"></s:label>
    <s:textfield name="username" label="账号"/>
    <s:password name="password" label="密码"/>
    <s:submit value="登录"/>
</s:form>
</body>
</html>
