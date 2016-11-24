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
<title>员工管理</title>
    <jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
    <script>
        $(function () {
            var anthortyId = $("#anthortyPid").children('option:checked').val();
            if(anthortyId == 1) {
                $("#anthortyUrl").attr("readonly", "readonly");
                $("#anthortyDesc").attr("readonly", "readonly");
            }
            $("#anthortyPid").change(function () {
                var anthortyId = $(this).children('option:checked').val();
                if(anthortyId == 1) {
                    $("#errorUrl").text("");
                    $("#anthortyUrl").parents( ".col-xs-5" ).removeClass( "has-error" );
                    $("#anthortyUrl").attr("readonly","readonly");
                    $("#anthortyDesc").attr("readonly","readonly");
                }else{
                    $("#anthortyUrl").removeAttr("readonly");
                    $("#anthortyDesc").removeAttr("readonly");
                }
            });

            $("#form").validate({
                submitHandler: function(form)
                {
                    if(checkUrl()){
                        $(form).ajaxSubmit({
                            dataType : 'json',
                            success:function (data) {
                                alert(data.message);
                                if(data.state){
                                    parent.loadTree(data.list);
                                }
                            },
                            resetForm:true
                        })
                    }
                },
                rules:{
                    anthortyName:"required"
                },
                messages:{
                    anthortyName:"权限名称不能为空!"
                },
                errorPlacement: function ( error, element ) {
                    error.addClass( "help-block" );
                    if ( element.prop( "type" ) === "checkbox" ) {
                        error.insertAfter( element.parent( "label" ) );
                    } else {
                        error.insertAfter( element );
                    }
                },
                highlight: function ( element, errorClass, validClass ) {
                    $( element ).parents( ".col-xs-5" ).addClass( "has-error" ).removeClass( "has-success" );
                },
                unhighlight: function (element, errorClass, validClass) {
                    $( element ).parents( ".col-xs-5" ).addClass( "has-success" ).removeClass( "has-error" );
                }
            });
        })
        function checkUrl(){
            var anthortyId = $("#anthortyPid").children('option:checked').val();
            if(anthortyId != 1){
                var anthortyUrl = $("#anthortyUrl").val();
                if(anthortyUrl == "" || anthortyUrl.length == 0){
                    $("#errorUrl").text("权限URL不能为空!");
                    $("#anthortyUrl").parents( ".col-xs-5" ).addClass( "has-error" ).removeClass( "has-success" );
                    return false;
                }
                $("#anthortyUrl").parents( ".col-xs-5" ).addClass( "has-success" ).removeClass( "has-error" );
            }
            return true;
        }
    </script>
</head>
<body>

<form action="anthorty/add.do" id="form" class="form-horizontal" method="post">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-xs-5">
        	<div class="form-group">
            	<label class="col-xs-3 control-label">权限编号</label>
                <div class="col-xs-9">
                	<input type="text" name="anthortyId" readonly="readonly"  class="form-control input-sm" placeholder="自动生成权限编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-xs-5">
            <div class="form-group">
            	<label class="col-xs-3 control-label">权限名称</label>
                <div class="col-xs-9">
                	<input type="text" name="anthortyName" class="form-control input-sm" placeholder="请输入权限名称" />
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-xs-5">
        	<div class="form-group">
            	<label class="col-xs-3 control-label">上级权限</label>
                <div class="col-xs-9">
                	<select name="anthortyPid" id="anthortyPid" class="form-control input-sm">
                		<c:forEach  items="${list }" var="anth">
                    	<option value="${anth.anthortyId }" ${anthortyId==anth.anthortyId?'selected':'' }  >${anth.anthortyName }</option>
                    	</c:forEach>
                    </select>
                </div>
            </div>
        
        </div>
        <div class="col-xs-5">
            <div class="form-group">
            	<label class="col-xs-3 control-label">权限URL</label>
                <div class="col-xs-9">
                	<input type="text" id="anthortyUrl" name="anthortyUrl" class="form-control input-sm" onblur="checkUrl()" placeholder="请输入权限URL"/>
                    <label id="errorUrl" class="control-label text-danger"></label>
                </div>
            </div>
        </div>
    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
    	<div class="col-xs-10">
        	<div class="form-group">
            	<label class="col-xs-3 control-label">备注</label>
                <div class="col-xs-9">
                	<textarea name="anthortyDesc" id="anthortyDesc" class="form-control"></textarea>
                </div>
            </div>
        
        </div>

    </div>
 	<div class="row">
    	<div class="col-xs-3 col-xs-offset-3">
        	<input  type="submit" class="btn btn-success" value="保存权限信息"/>
            <input  type="button" class="btn  btn-danger" onclick="window.parent.location.href='anthorty/list.do'" value="返回"/>
        </div>
    </div>

</form>

</body>
</html>