<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>管理</title>

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
        <li>员工薪水</li>
    </ul>
</div>
<form action="staffsalary/list"  method="post" class="form-inline" id="queryForm">
	<%-- 当前页 --%>
	<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
	<%-- 总页数 --%>
	<input type="hidden" id="pages" value="${page.pages}"/>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="staffName">员工姓名：</label>
        <input type="text" class="form-control" name="staffName" id="staffName" placeholder="请输入员工姓名">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="staffsalary/loadadd">添加员工薪水记录</a>
    
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
	<table class="table  table-condensed table-striped" name="list"  pagesize="10" requestURI="staffsalary/list.do">
		<tr>
			<td>领取人</td>
			<td>财务人员</td>
			<td>本月薪水</td>
			<td>扣除</td>
			<td>实际发放薪水</td>
			<td>领取日期</td>
			<td>备注信息</td>
			<td>是否领取</td>
		</tr>

			<c:forEach items="${page.list}" var="list">
				<tr>
				<td>${list.staffInfo.staffName}</td>
				<td>${list.financeName}</td>
				<td>${list.totalSalary}</td>
				<td>${list.deductSalary}</td>
				<td>${list.realSalary}</td>
				<td><f:formatDate value="${list.staffSalaryTime}" /> </td>
				<td>${list.staffRemark}</td>
				<td>${list.url}</td>
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