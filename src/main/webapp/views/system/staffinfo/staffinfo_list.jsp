<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>员工管理</title>
    <jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>

<script type="text/javascript">
	function  query(condititon){
		$("#keyword").attr("name",condititon.value);
	}
</script>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>员工管理</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form action="/system/query.do" method="post" class="form-horizontal" id="queryForm">
    <%-- 当前页 --%>
    <input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
    <%-- 总页数 --%>
    <input type="hidden" id="pages" value="${page.pages}"/>
	<div class="col-sm-1 block" >条件:</div>
    <div class="col-sm-3">
    	<select onchange="query(this)" name="condititon" class="form-control  input-sm">
    		<option value="">请选择</option>
        	<option value="staffId">编号</option>
            <option value="staffName">姓名</option>
            <option value="staffMobilePhone">移动电话</option>
        </select>
    </div>
    <div class="col-sm-3">
    	<input type="text"  id="keyword" class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"   value="查询"/>
    <input type="button"   class="btn btn-success"   value="添加" onClick="javascript:window.location='views/system/staffinfo/staffinfo_add.jsp'"/>
</form>
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
		</button>
		<p align="center" style="color: red;">员工信息-${info}</p>
	</div>
</div>
	
<div class="row" style="padding:15px; padding-top:0px; " align="right">
    <!-- 如果用户列表为空 -->
    <c:if test="${empty page.list}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>staffInfo表为空，请<a href="/system/add" type="button" class="btn btn-primary btn-sm">添加</a>
        </div>
    </c:if>
    <!--用户列表不为空-->
    <c:if test="${!empty page.list}">
        <table class="table table-bordered table-striped table-condensed text-center">
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>移动电话</td>
                <td>电子邮箱</td>
                <td>入职时间</td>
                <td>教育水平</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${page.list}" var="staff">
                <tr>
                    <td>${staff.staffId}</td>
                    <td>${staff.staffName}</td>
                    <td>${staff.staffSex}</td>
                    <td>${staff.staffAge}</td>
                    <td>${staff.staffMobilePhone}</td>
                    <td>${staff.staffEamil}</td>
                    <td>${staff.staffEntryTime}</td>
                    <td>${staff.staffEductionLevel}</td>
                    <td>
                        <a href="/system/show/${staff.staffId}"  type="button" class="btn btn-sm btn-success"
                           target="_self">详情</a>
                        <a href="/system/update/${staff.staffId}" type="button" class="btn btn-sm btn-warning"
                           target="_self">修改</a>
                        <a href="/system/delete/${staff.staffId}" type="button" class="btn btn-sm btn-danger"
                           target="_self">删除</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="9" style="text-align:center">
                    <ul id="paging"></ul>
                </td>
            </tr>
        </table>
    </c:if>
</div>
</body>
</html>