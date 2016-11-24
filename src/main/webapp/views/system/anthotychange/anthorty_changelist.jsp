<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>权限变更</title>
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>权限变更</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form  action="anthotychange/list.do" method="post" class="form-horizontal">
	<div class="col-sm-2">角色名称:</div>
    <div class="col-sm-3">
    	<input type="text"  name="roleName" class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"   value="查询"/>
 </form>
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">权限变更-${info }</p>
	</div>	
</div>

<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<table class="table  table-condensed table-striped" name="list">
		<thead>
			<tr>
				<th>角色编号</th>
				<th>角色名称</th>
				<th>角色描述</th>
				<th>权限变更</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="item">
			<tr>
				<td>${item.roleId}</td>
				<td>${item.roleName}</td>
				<td>${item.roleDesc}</td>
				<td><a href="anthotychange/load.do?roleId=${item.roleId}">权限变更</a></td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="4" style="text-align:center">
					<ul id="paging"></ul>
				</td>
			</tr>
		</tbody>
	</table>
</div>

</body>
</html>