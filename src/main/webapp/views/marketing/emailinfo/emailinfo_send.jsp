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
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>短信管理</title>
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
	<script type="text/javascript">

	function setText(obj){
	
		$("#emailTitle").val($(obj).find("option:selected").text());
		$("#emailContent").val(obj.value);
		if(obj.value ==''){
			$("#emailTitle").val('')
		}
	}
	$

</script>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">营销管理</a></li>
        <li>邮件管理</li>
        <li>发送邮件</li>
    </ul>
</div>

<frm:form action="email/send.do" method="post" class="form-horizontal" modelAttribute="EmailInfo">
    <frm:errors path="*"/>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">模板</label>
                <div class="col-sm-9">
              	<select name="" onchange="setText(this)" class="form-control input-sm">
                		<option value="">请选择</option>
                		<c:forEach items="${templist }" var="temp">
                    	<option value="${temp.templateContent }">${temp.templateTitle }</option>
               		    </c:forEach>
                    </select>
                </div>
            </div>
        
        </div>
    </div>
     	<div class="row">
                <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">主题</label>
                <div class="col-sm-9">
                	<input type="text" name="emailTitle" id="emailTitle" class="form-control input-sm" placeholder="请输入主题"/>
                </div>
            </div>
        </div>
        
        </div>
    	<div class="row">
                <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">接收人</label>
                <div class="col-sm-9">
                	<frm:input type="text" path="emailMan" class="form-control input-sm" placeholder="请输入接收人"/>
                </div>
            </div>
        </div>
        
        </div>
       
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">邮件地址</label>
                <div class="col-sm-9">
                	<frm:input type="text" path="emailAddr" class="form-control input-sm"  placeholder="请输入电话号码"/>
                </div>
            </div>
        
        </div>


    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">邮件内容信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">邮件内容</label>
                <div class="col-sm-9">
                	<frm:textarea id="emailContent" path="emailContent" class="form-control"></frm:textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="发送"/>

              <a class="btn btn-warning" href="email/list.do">返回上一级</a>
        </div>
    </div>
</frm:form>

</body>
</html>