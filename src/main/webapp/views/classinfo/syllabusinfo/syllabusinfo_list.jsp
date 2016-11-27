<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>课程管理</title>
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">班级管理</a></li>
        <li>课程表</li>
    </ul>
</div>
<form action="/syllabusInfo/list" method="post" class="form-inline" id="queryForm">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

    <div class="form-group">
         <label class="" for="syllabusName">课程表名称：</label>
        <input type="text" name="syllabusName" class="form-control" id="syllabusName" placeholder="请输入课程表名称">
      </div>
	<%-- 当前页 --%>
	<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
	<%-- 总页数 --%>
	<input type="hidden" id="pages" value="${page.pages}"/>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="views/classinfo/syllabusinfo/syllabusinfo_add.jsp">添加课程表</a>
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
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
			<td>课程表名称</td>
			<td>星期一</td>
			<td>星期二</td>
			<td>星期三</td>
			<td>星期四</td>
			<td>星期五</td>
			<td>星期六</td>
			<td>星期天</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list}" var="items">
			<tr>
				<td>${items.syllabusId}</td>
				<td>${items.syllabusName}</td>
				<td>${items.syllabusYi}</td>
				<td>${items.syllabusEr}</td>
				<td>${items.syllabusSan}</td>
				<td>${items.syllabusSi}</td>
				<td>${items.syllabusWu}</td>
				<td>${items.syllabusLiu}</td>
				<td>${items.syllabusQi}</td>
				<td>
					<a href="/syllabusInfo/selectById/${items.syllabusId}">修改</a>
					<a href="/syllabusInfo/delete/${items.syllabusId}" onclick="return confirm('确定删除吗？')">删除</a>
				</td>

			</tr>

		</c:forEach>

		<tr>
			<td colspan="10" style="text-align:center">
				<ul id="paging"></ul>
			</td>
		</tr>

	</table>
</div>

</form>
</body>
</html>