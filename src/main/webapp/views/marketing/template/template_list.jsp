<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    	<li><a href="#">营销管理</a></li>
        <li>短信邮件模板</li>
    </ul>
</div>
<form:form action="template/list.do" id="queryForm" class="form-horizontal" modelAttribute="templateInfo">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

	<div class="col-sm-2">标题:</div>
    <div class="col-sm-3">
    	<form:input type="text" path="templateTitle"  class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
		<%-- 当前页 --%>
	<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
		<%-- 总页数 --%>
	<input type="hidden" id="pages" value="${page.pages}"/>
    <a  class="btn btn-success"  href="template/load.do"   >添加模板</a>

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
</div>
	<table class="table  table-condensed table-striped">
		<tr>
			<tr>
			<td>编号</td>
			<td>标题</td>
			<td>内容</td>
			<td>类别</td>
		    <td>修改</td>
		    <td>删除</td>
		</tr>
		<c:forEach items="${requestScope.templateInfoList}" var="t">
			<tr>
				<td>${t.templateId}</td>
				<td>${t.templateTitle}</td>
				<td>${t.templateContent}</td>
				<td>${t.templateType}</td>
				<td><a href="/template/loadupdate.do/${t.templateId}">修改</a></td>
				<td><a href="/template/delete.do/${t.templateId}">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" style="text-align: center">
				<ul id="paging" ></ul>
			</td>
		</tr>
	</table>
  </form:form>

</body>
</html>