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
    <title>学科管理</title>
    <jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li>班级管理</li>
        <li>学科信息</li>
        <li>添加信息</li>
    </ul>
</div>

<form action="disciplineinfo/add" class="form-horizontal" method="post">
	<input type="hidden" name="disciplineIsuesd" value="1"/>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="disciplineId" readonly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">学科名称</label>
                <div class="col-sm-9">
                	<input type="text" name="disciplineName" class="form-control input-sm" placeholder="请输入学科名称"/>
                </div>
            </div>
        </div>

    </div>
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">学科费用</label>
                <div class="col-sm-9">
               			<input type="text" name="disciplineTuition" class="form-control input-sm" placeholder="请输入学科费用"/>
                </div>
            </div>
        </div>
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">学科课时</label>
                <div class="col-sm-9">
               		 <input type="text" name="disciplineBring" class="form-control input-sm" placeholder="请输入学科课时"/>
                </div>
            </div>
        
        </div>

    </div>

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">描述</label>
                <div class="col-sm-9">
                	<textarea name="disciplineDesc" class="form-control"></textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="/disciplineinfo/list.do">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>