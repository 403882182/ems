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
<!doctype html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>招生线索</title>
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li>招生管理</li>
        <li>招生线索</li>
    </ul>
</div>
<form action="recruitstudent/list.do" method="post" class="form-inline" id="queryForm">
	<%-- 当前页 --%>
	<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
	<%-- 总页数 --%>
	<input type="hidden" id="pages" value="${page.pages}"/>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">学员姓名：</label>
        <input type="text" name="studentName" class="form-control" id="activename" placeholder="请输入学员姓名">
      </div>
  	<div class="form-group">
         <label class="" for="activename">学员意向状态：</label>
			<s:select name="studentSate" type="student_sate" selectedId="${stuinfo.studentSate }"/>
      </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="views/recruitstudent/recruitstudent/recruitstudent_add.jsp">添加学员</a>
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
			<td>姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>手机号码</td>
			<td>电子邮件</td>
			<td>所在院校</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list}" var="items">
			<tr>
				<td>${items.studentId}</td>
				<td><a href="/recruitstudent/show.do?studentId=${items.studentId}">${items.studentName}</a></td>
				<td>${items.studentSex}</td>
				<td>${items.studentAge}</td>
				<td>${items.studentTellphone}</td>
				<td>${items.studentEmail}</td>
				<td>${items.studentSchool}</td>
				<td><a href="/recruitstudent/load.do?studentId=${items.studentId}">修改</a>
					<a href="/recruitstudent/delete.do?studentId=${items.studentId}">删除</a>
				</td>

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