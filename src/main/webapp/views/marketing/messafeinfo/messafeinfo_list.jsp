<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>短信管理</title>
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
	<script>
		$(function (){
			$(".delete").click(function () {
				var href=$(this).attr("href");
				$("#from1").attr("action",href).submit();
				return false;
			})
				})
	</script>
</head>
<body>
<form id="form1" action="" method="post">
	<input type="hidden" name="_method" value="DELETE">
</form>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">营销管理</a></li>
        <li>短信管理</li>
    </ul>
</div>
<form:form action="messafeinfo/list.do" id="queryForm" method="post" class="form-horizontal" modelAttribute="messafeInfo">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

	<div class="col-sm-2">电话号码:</div>
    <div class="col-sm-3">
    	<form:input type="text" path="messafePhone"  class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
		<%-- 当前页 --%>
	<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
		<%-- 总页数 --%>
	<input type="hidden" id="pages" value="${page.pages}"/>
    <a  class="btn btn-success"  href="messafeinfo/load.do"   >发送短信</a>
   
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
			<td>发送人</td>
			<td>发送时间</td>
			<td>接收人</td>
			<td>接收号码</td>
			<td>查看</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${page.list}" var="m">
				<tr>
					<td>${m.messafeId}</td>
					<td>${m.staffInfo.staffName}</td>
					<td><f:formatDate value="${m.messafeTime}" dateStyle="full"/> </td>
					<td>${m.messafeMan}</td>
					<td>${m.messafePhone}</td>
					<td><a href="/messafeinfo/show.do/${m.messafeId}">查看</a></td>
					<td><a class=".delete" href="/email/delete.do/${m.messafeId}">删除</a></td>
				</tr>
		</c:forEach>
		<tr>
			<td colspan="7" style="text-align: center">
				<ul id="paging" ></ul>
			</td>
		</tr>
	</table>
</div>

 </form:form>
</body>
</html>