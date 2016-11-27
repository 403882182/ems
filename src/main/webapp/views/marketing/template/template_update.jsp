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
<title>模板管理</title>
    <jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>
	
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">营销管理</a></li>
        <li>模板管理</li>
        <li>修改信息</li>
    </ul>
</div>

<form action="template/update.do" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="templateId" value="${templateInfo.templateId }" readonly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">标题</label>
                <div class="col-sm-9">
                	<input type="text" name="templateTitle" value="${templateInfo.templateTitle }" class="form-control input-sm" placeholder="请输入标题"/>
                </div>
            </div>
        </div>

    </div>
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">类型</label>
                <div class="col-sm-9">
                	<select name="templateType" class="form-control input-sm">
                    	<option value="短信" ${templateInfo.templateType=='短信'?'selected':'' } >短信模板</option>
                   	    <option value="邮件" ${templateInfo.templateType=='邮件'?'selected':'' }>邮件模板</option>
                    </select>
                </div>
            </div>
        
        </div>


    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">内容信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">内容信息</label>
                <div class="col-sm-9">
                	<textarea name="templateContent" class="form-control">${templateInfo.templateContent}</textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存模板"/>

              <a class="btn btn-warning" href="template/list.do">返回上一级</a>
        </div>
    </div>
</form>
	
</body>
</html>