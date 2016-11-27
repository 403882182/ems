<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="http://jyw.com" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>班级管理</title>
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>




<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li>班级管理</li>
        <li>班级信息</li>
    </ul>
</div>
<form action="/classinfo/list.do"  method="post" class="form-inline" id="queryForm" >
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="className">班级名称：</label>
        <input type="text" name="className" class="form-control" id="className" placeholder="请输入班级名称">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
	<%-- 当前页 --%>
	<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
	<%-- 总页数 --%>
	<input type="hidden" id="pages" value="${page.pages}"/>
    <a  class="btn btn-success"  href="/classinfo/addload">添加班级</a>
    
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
				<td>班级名称</td>
				<td>班级人数</td>
				<td>开班日期</td>
                <td>结束日期</td>
				<td>操作</td>
			</tr>
	<c:forEach items="${page.list}" var="items">
		<tr>
			<td>${items.classId}</td>
			<td>${items.className}</td>
			<td>${items.classNumber}</td>
			<td><fmt:formatDate value="${items.classStartTime}" type="both"/> </td>
			<td><fmt:formatDate value="${items.classEndTime}" type="both"/></td>
			<td>
                <a href="/classinfo/selectById/${items.classId}">修改</a>

                <a href="/classinfo/delete/${items.classId}" onclick="return confirm('确认删除吗？')">删除</a></td>

		</tr>
	</c:forEach>
			<tr>
				<td colspan="6" style="text-align:center">
	     			<ul id="paging"></ul>
				</td>
			</tr>
		</table>

</div>

</form>
</body>
</html>