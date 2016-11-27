<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="s" uri="http://beifengwang.com" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>--%>
<!doctype html>
<html>
<head>

<base href="<%=basePath%>">
<title>营销活动</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/bootstrap-paginator.min.js"></script>
	<script src="resources/js/paging.js"></script>

</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">财务管理</a></li>
        <li>查询学员</li>
    </ul>
</div>
<form action="studentpayment/list" method="post" class="form-inline" id="queryForm">
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

      </div>

    <input type="submit"   class="btn btn-danger" value="查询"/>

</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true"></span>

		</button>
		<p align="center" style="color: red;">${info}</p>
	</div>
</div>
<div class="row" style="padding:15px; padding-top:0px; " align="right">
		<table class="table  table-condensed table-striped">
			<tr>
                <td >编号</td>
                <td>姓名</td>
                <td>性别 </td>
                <td>年龄</td>
                <td>手机号码</td>
                <td >电子邮件</td>
                <td >所在院校</td>
				<td >学员缴费</td>
			</tr>

				<c:forEach items="${page.list}" var="list">
			<tr>
					<td>${list.studentId}</td>
					<td><a href="studentpayment/payment/${list.studentId}">${list.studentName}</a></td>
					<td>${list.studentSex}</td>
					<td>${list.studentAge}</td>
					<td>${list.studentTellphone}</td>
                    <td>${list.studentEmail}</td>
					<td>${list.studentSchool}</td>
					<td><a href="studentpayment/loadpayment/${list.studentId}">学员缴费</a></td>
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