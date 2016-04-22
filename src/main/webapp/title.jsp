<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        body {
            font-family: verdana, sans-serif;
            font-size: 14px;
        }

        #navigation, #navigation li ul {
            list-style-type: none;

        }

        #navigation {
        }

        #navigation li {
            float: left;
            text-align: center;
            position: relative;
        }

        #navigation li a:link, #navigation li a:visited {
            display: block;
            text-decoration: none;
            color: #fff;
            width: 100px;
            height: 40px;
            line-height: 40px;
            border: 1px solid #fff;
            border-width: 0px 0px 0 0;
            background: #69c2ec;
            background: linear-gradient(0deg, #69c2ec 0%, #8bd9ff 100%);
            padding-left: 10px;

        }

        #navigation li a:hover {
            color: #fff;

            background: none repeat scroll 0 0 #59b5de;
        }

        #navigation li ul li a:hover {
            color: #fff;
            background: none repeat scroll 0 0 #59b5de;

        }

        #navigation li ul {
            display: none;
            position: absolute;
            top: 40px;
            margin-top: 1px;
            font-size: 16px;
        }
    </style>
    <script type="text/javascript">
        function displaySubMenu(li) {                        //显示子按钮
//				var 
            var subMenu = li.getElementsByTagName("ul")[0];
            subMenu.style.display = "block";
        }
        function hideSubMenu(li) {                           //隐藏子按钮
            var subMenu = li.getElementsByTagName("ul")[0];
            subMenu.style.display = "none";
        }
    </script>
</head>
<body>
<div id="top">
    <div id="top_content">
        <div style="float: left;height: 27px;vertical-align: middle;padding-left: 16px;">
            <img style="float: left;margin-bottom: 10px;" src="${ctx}/static/images/logonn.png"/>
            <!--<div style="float: left;padding-left: 10px;font-size: 22px;color: #FF6200;font-weight: bold;padding-top: 10px;font-family:微软雅黑;">标签系统</div>  -->
        </div>
        <table align="left" width="70%">
            <tr>
                <td width="4%"></td>
                <td width="76%" style="margin-left: 20px;">
                    <ul id="navigation">
                        <c:forEach var="pf" items="${funcs}">
                            <c:if test="${pf.childList == null || fn:length(pf.childList) == 0}">
                                <li id="${pf.code}">
                                    <a href="${ctx}/${pf.url}" style="font-size: 15px;font-weight: bold;">${pf.name}</a>
                                </li>
                            </c:if>
                            <c:if test="${fn:length(pf.childList)>0}">
                                <li id="${pf.id}" onmouseover="displaySubMenu(this)" onmouseout="hideSubMenu(this)">
                                    <div id="div${pf.id}"><a href="#"
                                                             style="font-size: 15px;font-weight: bold;">${pf.name}</a>
                                    </div>
                                    <ul>
                                        <c:forEach var="cf" items="${pf.childList}">
                                            <li><a href="${ctx}/${cf.url}"
                                                   style="font-size: 15px;font-weight: bold;">${cf.name}</a></li>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </td>
                <td style="padding-left: 10px;">
                    <div class="welcome" style="color: #fff;font-weight: bold;">欢迎您：${requestScope.name}
                        <a style="padding-left: 10px;color: #fff;text-decoration: NONE;font-weight: bold;"
                           href="${ctx}/auth/logout.do">[注销]</a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
