<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>短信管理</title>
    <jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
    <script>
        $(function(){
            $(".delete").click(function(){
                var href=$(this).attr("href");
                $("#from1").attr("action",href).submit();
                return false;

            })
        })
    </script>
</head>
<body>
<form id="from1" action="" method="POST">
    <input type="hidden" name="_method" value="DELETE"/>
</form>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li>营销管理</li>
        <li>邮件管理</li>
    </ul>
</div>
<form:form action="email/list.do" id="queryForm" method="get" cssClass="form-horizontal" modelAttribute="EmailInfoEx">
    <%-- 查询条件添加 --%>
    <div class="row alert alert-info"  style="margin:0px; padding:3px;" >
        <div class="col-sm-2">主题:</div>
        <div class="col-sm-3">
            <form:input path="emailTitle" cssClass="form-control input-sm"/>
        </div>
        <input type="submit"  class="btn btn-danger"     value="查询"/>
        <a  class="btn btn-success"  href="email/load.do"   >发送邮件</a>
    </div>
    <%-- 当前页 --%>
    <input type="hidden" name="pageNum" id="pageNum" value="${page.pageNum}"/>
    <%-- 总页数 --%>
    <input type="hidden" id="pages" value="${page.pages}"/>

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
            <td>
                编号
            </td>
            <td>
                主题
            </td>
            <td>
                发送人
            </td>
            <td>
                发送时间
            </td>
            <td>
                接收人
            </td>
            <td>
                接收地址
            </td>
            <td>
                查看
            </td>
            <td>
                删除
            </td>
        </tr>
        <s:forEach items="${page.list}" var="e">
                <tr>
                    <td>
                        ${e.emailId}
                    </td>
                    <td>
                        ${e.emailTitle}
                    </td>
                    <td>
                        ${e.staffInfo.staffName}
                    </td>
                    <td>
                            <f:formatDate value="${e.emailTime}" dateStyle="full"/>

                    </td>
                    <td>
                            ${e.emailMan}
                    </td>
                    <td>
                        ${e.emailAddr}
                    </td>
                    <td>
                        <a href="/email/show.do/${e.emailId}">查看</a>
                    </td>
                    <td>
                        <a class="delete" href="/email/delete.do/${e.emailId}">删除</a>
                    </td>
                </tr>
        </s:forEach>
        <tr>
            <td colspan="8" style="text-align: center">
               <ul id="paging" ></ul>
            </td>
        </tr>
    </table>
    </form:form>
</div>
</body>
</html>