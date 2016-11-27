<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="http://jyw.com"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>营销活动</title>
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li>营销管理</li>
        <li>营销活动</li>
    </ul>
</div>
<form:form method="post" id="queryForm" action="marketactive/list.do" class="form-inline" modelAttribute="marketActiveEx">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activeName">活动名称：</label>
        <form:input type="text" class="form-control" path="activeName" id="activeName" placeholder="请输入活动名称"/>
      </div>
      <div class="form-group">
         <label class="" for="activeState">活动状态：</label>
		 <s:select type="active_state"  name="activeState"  />

      </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
		<%-- 当前页 --%>
	<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
		<%-- 总页数 --%>
	<input type="hidden" id="pages" value="${page.pages}"/>
    <a  class="btn btn-success"  href="marketactive/loadadd.do">添加活动</a>
 
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
			<td>编号/</td>
			<td>活动名称</td>
			<td>负责人</td>
			<td>开始时间</td>
			<td>结束时间</td>
			<td>活动状态</td>
			<td>查看/修改</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${page.list}" var="m">
			<tr>
				<td>${m.activeId}</td>
				<td>${m.activeName}</td>
				<td>${m.staffInfo.staffName}</td>
				<td><f:formatDate value="${m.activeStart}" dateStyle="full"/></td>
				<td><f:formatDate value="${m.activeEnd}" dateStyle="full"/></td>
				<td>${m.dataDictionary.dataContent}</td>
				<td><a href="/marketactive/load.do/${m.activeId}">查看/修改</a></td>
				<td><a href="/marketactive/delete.do/${m.activeId}">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8" style="text-align: center">
				<ul id="paging" ></ul>
			</td>
		</tr>
	</table>
</div>
   </form:form>
</body>
</html>