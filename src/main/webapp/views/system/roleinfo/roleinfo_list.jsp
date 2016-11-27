<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>角色管理</title>
    <jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li>系统管理</li>
        <li>角色管理</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form  action="/roleinfo/query.do" method="post" class="form-horizontal" id="queryForm">
    <%-- 当前页 --%>
    <input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
    <%-- 总页数 --%>
    <input type="hidden" id="pages" value="${page.pages}"/>
	<div class="col-sm-2">角色名称:</div>
    <div class="col-sm-3">
    	<input type="text"  name="roleName" class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"   value="查询"/>
    <input type="button"   class="btn btn-success"   value="添加" onClick="javascript:window.location='<%=basePath%>views/system/roleinfo/roleinfo_add.jsp'"/>
</form>
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">角色信息-${info }</p>
	</div>	
</div>
<div class="row" style="padding:15px; padding-top:0px; " align="right">
    <table class="table table-bordered table-striped table-condensed text-center">
        <tr>
            <td>角色编号</td>
            <td>角色名称</td>
            <td>角色描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${page.list}" var="roleInfo">
            <tr>
                <td>${roleInfo.roleId}</td>
                <td>${roleInfo.roleName}</td>
                <td>${roleInfo.roleDesc}</td>
                <td><a type="button" class="btn btn-sm btn-warning" href="roleinfo/update/${roleInfo.roleId}"
                       target="_self">修改</a>
                    <a type="button" class="btn btn-sm btn-danger" href="roleinfo/delete/${roleInfo.roleId}"
                       target="_self">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" style="text-align:center">
                <ul id="paging"></ul>
            </td>
        </tr>
    </table>
</div>
</body>
</html>