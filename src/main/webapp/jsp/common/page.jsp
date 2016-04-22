<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<div class="ye_num">
    <input type="hidden" name="page" id="page" value="${page.page}">
    <input type="hidden" name="li" value="<%=request.getParameter("li") %>">
    <span>当前第${page.page}页，共有${page.totalPages}页，共${page.total}条，每页显示${page.pageSize}条记录</span>
    <input name="diyiye" type="button" class="an_ye" onclick="jumpPage(1)" value="第一页"/>
    <c:if test="${page.page>1}">
        <input name="shangyiye" type="button" class="an_ye" onclick="jumpPage(${page.page-1 })" value="上一页"/>
    </c:if>
    <c:if test="${page.page<page.totalPages}">
        <input name="xiayiye" type="button" class="an_ye" onclick="jumpPage(${page.page+1 })" value="下一页"/>
    </c:if>
    <input name="zuihouyiye" type="button" class="an_ye" onclick="jumpPage(${page.totalPages})" value="最后一页"/>
    &nbsp;&nbsp;跳转到：
    <input name="tiaozhuanzhi" id="tiaozhuanzhi" type="text" style="width:30px; height:19px;"/>
    <input onclick="commit(${page.totalPages})" type="button" value="确定" class="an_ye"/>&nbsp;&nbsp;
</div>


