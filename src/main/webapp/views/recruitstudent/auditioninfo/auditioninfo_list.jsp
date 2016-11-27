<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<%@ taglib prefix="s" uri="http://jyw.com" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>试听记录</title>
    <jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li>招生管理</li>
        <li>试听记录</li>
    </ul>
</div>
<form action="auditioninfo/list.do" method="post" class="form-inline" id="queryForm">

    <%-- 当前页 --%>
    <input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
    <%-- 总页数 --%>
    <input type="hidden" id="pages" value="${page.pages}"/>

    <div class="row alert alert-info" style="margin:0px; padding:3px;">

        <div class="form-group">
            <label class="" for="studentName">学员姓名：</label>
            <input type="text" class="form-control" name="studentName" id="studentName" placeholder="请输入学员姓名">
        </div>
        <div class="form-group">
            <label class="" for="auditionCourse">试听课程：</label>
            <input type="text" class="form-control" name="auditionCourse" id="auditionCourse" placeholder="请输入试听课程">
        </div>
        <input type="submit" class="btn btn-danger" value="查询"/>
        <a class="btn btn-success" href="auditioninfo/loadadd.do">添加纪录</a>

    </div>
    <div align="center">
        <div class="alert alert-warning"
             style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
            <button type="button" class="close" data-dismiss="alert">
                <span aria-hidden="true">&times;</span>

            </button>
            <p align="center" style="color: red;">${info }</p>
        </div>
    </div>
    <div class="row" style="padding:15px; padding-top:0px; " align="right">
        <table class="table  table-condensed table-striped">
            <tr>
                <td>编号</td>
                <td>学员姓名</td>
                <td>试听课程</td>
                <td>试听时间</td>
                <td>地点</td>
                <td>试听描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${page.list}" var="items">
                <tr>
                    <td>${items.auditionId}</td>
                    <td>${items.studentInfo.studentName}</td>
                    <td>${items.auditionCourse}</td>
                    <td><fmt:formatDate value="${items.auditionTime}" /></td>
                    <td>${items.auditionAddr}</td>
                    <td>${items.auditionDesc}</td>
                    <td><a href="auditioninfo/loadupdate.do?auditionId=${items.auditionId}">修改</a></td>
                    <td><a href="auditioninfo/delete.do?auditionId=${items.auditionId}">删除</a></td>
                </tr>

            </c:forEach>
            <tr>
                <td colspan="8" style="text-align:center">
	                <ul id="paging"></ul>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>