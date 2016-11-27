<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="http://jyw.com" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>评价管理</title>
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">学员管理</a></li>
        <li>学员评价</li>
    </ul>
</div>
<frm:form action="evaluationinfo/list.do" id="queryForm" class="form-inline" modelAttribute="evaluationInfoEx">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="studentName">学员姓名：</label>
        <frm:input type="text" path="studentInfo.studentName" class="form-control" id="studentName" placeholder="请输入学员姓名" />
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
	<%-- 当前页 --%>
	<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
	<%-- 总页数 --%>
	<input type="hidden" id="pages" value="${page.pages}"/>
    <a  class="btn btn-success"  href="evaluationinfo/loadadd.do">添加评价</a>
    
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
				<td>学员姓名</td>
				<td>主题</td>
				<td>评价内容</td>
				<td>课程名称</td>
				<td>教师</td>
				<td>评价时间</td>
				<td>修改/查看</td>
				<td>删除</td>
			</tr>
		<c:forEach items="${evaluationInfoices}" var="e">
				<tr>
					<td>${e.evaluationId}</td>
					<td>${e.studentInfo.studentName}</td>
					<td>${e.evaluationTitle}</td>
					<td>${e.evaluationContent}</td>
					<td>${e.evaluationCourse}</td>
					<td>${e.evaluationTeacher}</td>
					<td><f:formatDate value="${e.evaluationTime}"/></td>
					<td><a href="/evaluationinfo/loadupdate.do/${e.evaluationId}">修改/查看</a></td>
					<td><a href="/evaluationinfo/delete.do/${e.evaluationId}">删除</a></td>
				</tr>
		</c:forEach>
		<tr>
			<td colspan="9" style="text-align: center">
				<ul id="paging" ></ul>
			</td>
		</tr>
	</table>
</div>
</frm:form>





</body>
</html>