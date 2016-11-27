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
<title>短信管理</title>
    <jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
    <script>
        $(function () {
            top.updateEmail();
        })
    </script>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li>营销管理</li>
        <li>邮件管理</li>
        <li>查看信息</li>
    </ul>
</div>

<form action="" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">发送人</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${emailInfo.staffInfo.staffName }</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">发送时间</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${emailInfo.emailAddr }</p>
                </div>
            </div>
        </div>
    </div>
    
    	<div class="row">
                <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">接收人</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${emailInfo.emailMan }</p>
                </div>
            </div>
        </div>
        
        </div>
    
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">接收地址</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${emailInfo.emailAddr }</p>
                </div>
            </div>
        
        </div>


    </div>
    
      	<div class="row">
                <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">主题</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${emailInfo.emailTitle }</p>
                </div>
            </div>
        </div>
        
        </div>
    



    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">邮件内容</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">邮件内容</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${emailInfo.emailContent }</p>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
   

              <a class="btn btn-warning" href="email/list.do">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>