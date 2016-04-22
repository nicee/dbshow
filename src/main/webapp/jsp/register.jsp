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
    <title>SSI-Register -- Product by Nicee</title>
</head>
<body>
<s:form action="/register.action" method="post">
    <s:label value="用户注册"></s:label>
    <s:textfield name="username" label="账号"/>
    <s:password name="password" label="密码"/>
    <s:submit value="注册"/>
</s:form>

<p>如果注册相同的账号名称，在登陆时将会抛出异常，请勿提交同名账号</p>

<a href="/">返回首页</a>

</body>
</html>
