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
	<title>学科管理</title>
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
	<script src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>

</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">班级管理</a></li>
        <li>学科信息</li>
    </ul>
</div>
<form action="/disciplineinfo/list" method="post" class="form-inline"  id="queryForm">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="disciplineName">学科名称：</label>
        <input type="text" class="form-control" name="disciplineName" id="disciplineName" placeholder="请输入学科名称">
      </div>
	<%-- 当前页 --%>
	<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
	<%-- 总页数 --%>
	<input type="hidden" id="pages" value="${page.pages}"/>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="views/classinfo/disciplineinfo/disciplineinfo_add.jsp">添加学科信息</a>
    
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: #ff0000;">${info }</p>
	</div>	
</div>
<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<table class="table  table-condensed table-striped">
		<tr>
			<td>编号</td>
			<td>学科名称</td>
			<td>学科费用</td>
			<td>学科课时</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list}" var="items">
			<tr>
				<td>${items.disciplineId}</td>
				<td>${items.disciplineName}</td>
				<td>${items.disciplineTuition}</td>
				<td>${items.disciplineBring}</td>
				<td>
					<a href="/disciplineinfo/selectById/${items.disciplineId}">修改</a>
					<a href="/disciplineinfo/delete/${items.disciplineId}" onclick="return confirm('确定删除吗？')">删除</a>
				</td>

			</tr>

		</c:forEach>
		<tr>
			<td colspan="5" style="text-align:center">
				<ul id="paging"></ul>
			</td>
		</tr>

	</table>
</div>

</form>
</body>
</html>