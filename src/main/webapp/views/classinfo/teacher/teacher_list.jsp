<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>员工管理</title>
    <jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>

    <script type="text/javascript">

        function query(condititon) {
            $("#keyword").attr("name", condititon.value);
        }


    </script>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li>班级管理</li>
        <li>教师管理</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;" >
    <form action="/teacher/list.do" method="post" class="form-horizontal" id="queryForm">
        <div class="col-sm-1">条件:</div>
        <div class="col-sm-3">
            <select onchange="query(this)" name="condititon" class="form-control  input-sm">
                <option value="">请选择</option>
                <option value="staffId">编号</option>
                <option value="staffName">姓名</option>
                <option value="staffMobilePhone">移动电话</option>
            </select>
        </div>
        <%-- 当前页 --%>
        <input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
        <%-- 总页数 --%>
        <input type="hidden" id="pages" value="${page.pages}"/>
        <div class="col-sm-3">
            <input type="text" id="keyword" class="form-control input-sm"/>
        </div>
        <input type="submit" class="btn btn-danger" value="查询"/>
        <input type="button" class="btn btn-success" value="添加"
               onClick="javascript:window.location='views/classinfo/teacher/teacher_add.jsp'"/>
    </form>
</div>
<div align="center">
    <div class="alert alert-warning"
         style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
        <button type="button" class="close" data-dismiss="alert">
            <span aria-hidden="true">&times;</span>

        </button>
        <p align="center" style="color: red;">员工信息-${info }</p>
    </div>
</div>

<div class="row" style="padding:15px; padding-top:0px; " align="right">
    <table class="table  table-condensed table-striped">
        <tr>
            <td>教师编号</td>
            <td>教师姓名</td>
            <td>教师性别</td>
            <td>教师年龄</td>
            <td>移动电话</td>
            <td>电子邮箱</td>
            <td>入职时间</td>
            <td>教育水平</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${page.list}" var="item">
            <tr>
                <td><a href="/teacher/selectByIds/${item.staffId}">${item.staffId}</a></td>
                <td>${item.staffName}</td>
                <td>${item.staffSex}</td>
                <td>${item.staffAge}</td>
                <td>${item.staffMobilePhone}</td>
                <td>${item.staffEamil}</td>
                <td><fmt:formatDate value="${item.staffEntryTime}"/></td>
                <td>${item.staffEductionLevel}</td>
                <td>
                    <a href="/teacher/selectById/${item.staffId}">修改</a>
                    <a href="/teacher/delete/${item.staffId}" onclick="return confirm('确定删除吗？')">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="9" style="text-align:center">
                <ul id="paging"></ul>
            </td>
        </tr>
    </table>
</div>
</body>
</html>