<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="http://jyw.com" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>沟通记录管理</title>
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li>学员管理</li>
        <li>学员沟通记录</li>
    </ul>
</div>
<frm:form action="communicateinfo/list.do" id="queryForm"  method="post" class="form-inline" modelAttribute="communicateInfo">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="studentName">学员姓名：</label>
        <frm:input type="text" class="form-control" path="studentInfo.studentName" id="studentName" placeholder="请输入学员姓名"/>
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
	<%-- 当前页 --%>
	<input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
	<%-- 总页数 --%>
	<input type="hidden" id="pages" value="${page.pages}"/>
    <a  class="btn btn-success"  href="communicateinfo/loadadd.do">添加沟通记录</a>
    
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
		<td>负责人</td>
        <td>沟通时间</td>
		<td>沟通内容</td>
		<td>修改/查看</td>
		<td>删除</td>
	</tr>
	<c:forEach items="${communicateInfoExList}" var="comm">
			<tr>
			<td>${comm.communicateId}</td>
			<td>${comm.studentInfo.studentName}</td>
			<td>${comm.staffInfo.staffName}</td>
			<td><f:formatDate value="${comm.communicateTime}"/></td>
                <td>${comm.communicateContent}</td>
			<td><a href="/communicateinfo/loadupdate.do/${comm.communicateId}">修改/查看</a></td>
			<td><a href="/communicateinfo/delete.do/${comm.communicateId}">删除</a></td>
			</tr>
	</c:forEach>
	<tr>
		<td colspan="7" style="text-align: center">
			<ul id="paging" ></ul>
		</td>
	</tr>
</table>
</div>

</frm:form>




</body>
</html>