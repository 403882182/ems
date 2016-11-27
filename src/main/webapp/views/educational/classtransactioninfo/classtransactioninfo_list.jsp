<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>班级事务管理</title>
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">教务管理</a></li>
        <li>班级事务</li>
    </ul>
</div>
<form action="classtransactioninfo/list.do" id="queryForm"  method="post" class="form-inline">
	<%-- 查询条件添加 --%>
	<form:input path=""/>
	<%-- 当前页 --%>
	<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
	<%-- 总页数 --%>
	<input type="hidden" id="pages" value="${page.pages}"/>
	<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
 	<div class="form-group">
         <label class="" for="classTransactionTitle">主题：</label>
        <input type="text" class="form-control" name="classTransactionTitle" id="classTransactionTitle" placeholder="请输入主题">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="classtransactioninfo/selectClassInfo">添加班级事务</a>
    
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">${info }</p>
	</div>	
</div>
	<table class="table  table-condensed table-striped" name="list" pagesize="10">
		<tr>
			<td>编号</td>
			<td>班级</td>
			<td>主题</td>
			<td>内容</td>
			<td>组织人</td>
			<td>活动日期</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list}" var="list">
			<tr>
				<td>${list.classTransactionId}</td>
				<td>${list.classInfo.className}</td>
				<td>${list.classTransactionTitle}</td>
				<td>${list.classTransactionContent}</td>
				<td>${list.classTransactionPerson}</td>
				<td><fmt:formatDate value="${list.classTransactionTime}"/></td>
				<td><a href="classtransactioninfo/updateList?classTransactionId=${list.classTransactionId}">修改</a><a href="classtransactioninfo/deleteByPrimaryKey?classTransactionId=${list.classTransactionId} ">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" style="text-align:center">
	     <ul id="paging"></ul>
			</td>
		</tr>
	</table>

</form>




</body>
</html>