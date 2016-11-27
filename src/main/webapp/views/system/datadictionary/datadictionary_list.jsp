<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>数据字典</title>
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li>系统管理</li>
        <li>数据字典</li>
    </ul>
</div>
<form:form action="datadictionary/list.do" id="queryForm" method="post" modelAttribute="DataDictionary" cssClass="form-horizontal">
	<%-- 查询条件添加 --%>
	<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

		<div class="col-sm-2">类型:</div>
		<div class="col-sm-3">
			<form:input path="dataType" cssClass="form-control input-sm"/>
		</div>
		<input type="submit"   class="btn btn-danger"     value="查询"/>
		<a  class="btn btn-success"  href="views/system/datadictionary/datadictionary_add.jsp">添加</a>

	</div>
	<div align="center">
		<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>

			</button>
			<p align="center" style="color: #ff0000;">${info }</p>
		</div>
	</div>
	<%-- 当前页 --%>
	<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
	<%-- 总页数 --%>
	<input type="hidden" id="pages" value="${page.pages}"/>
</form:form>

<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<table class="table  table-condensed table-striped">
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>类型</td>
			<td>描述</td>
			<td colspan="2">操作</td>
		</tr>
		<c:forEach items="${page.list}" var="item">
			<tr>
				<td>${item.dataId}</td>
				<td>${item.dataContent}</td>
				<td>${item.dataType}</td>
				<td>${item.dataDesc}</td>
				<td colspan="2">
					<a href="/datadictionary/load.do?dataId=${item.dataId}"  title="修改">修改</a>
					<a href="/datadictionary/delete.do?dataId=${item.dataId}&pageNum=${page.pageNum}&dataType=${DataDictionary.dataType}"  title="删除">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" style="text-align:center">
	   		  <ul id="paging"></ul>
			</td>
		</tr>
	</table>
</div>

</body>
</html>