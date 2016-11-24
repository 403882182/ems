<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.jyw.model.AnthortyInfo"%>
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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/dtree.css">
	<jsp:include page="${pageContext.request.contextPath}/views/common/script.jsp"/>
	<script src="${pageContext.request.contextPath}/resources/js/dtree.js"></script>
	<script>
		function loadTree(list){
            tree = new dTree('tree');
            $.each(list,function (i,item) {
                tree.add(item.anthortyId,item.anthortyPid, item.anthortyName
                        +'', 'anthorty/show.do?anthortyId='+item.anthortyId, '', 'mainiframe');
            });
            $("#treeDiv").html(tree.toString());
		}
	</script>
</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>权限管理</li>
    </ul>
</div>

<div class="row">

	<div class="col-sm-2"  style=" padding-left:30px;" id="treeDiv">
    	<script type="text/jscript">

			<%--
				1.定义js树对象
					tree = new dTree('tree');
				2.增加 js树结点
					add(id,pid,name,url,title,target,icon,iconOpen,open);
				3.// 输出js树
					document.write(tree);
			--%>
			tree = new dTree('tree');
			<%
				List<AnthortyInfo> list =  (List<AnthortyInfo>)request.getAttribute("list");
				if(list!=null && list.size()>0){
					for(AnthortyInfo anth :list){
			%>
				tree.add(
						<%--节点自身的id(唯一)--%>
						<%=anth.getAnthortyId()%>,
						<%--节点的父节点id--%>
						<%=anth.getAnthortyPid()%>,
						<%--节点显示在页面上的名称--%>
						'<%=anth.getAnthortyName()%>',
						<%--节点的链接地址--%>
						'anthorty/show.do?anthortyId=<%=anth.getAnthortyId()%>',
						<%--鼠标放在节点上显示的提示信息--%>
						'',
						<%--节点链接所打开的目标frame--%>
						'mainiframe',
						<%--节点关闭状态时显示的图标--%>
						'',
						<%--节点打开状态时显示的图标--%>
						'',
						<%--节点第一次加载是否打开--%>
						''
				);
			<%
					}
				}
			%>
			document.write(tree);
        </script>
    </div>
    <div class="col-sm-10">
    	<iframe id="mainframe" name="mainiframe"  style="width:100%; border:0px; " ></iframe>
        <script type="text/javascript">
        	var height = jQuery(window).height()-50;
			jQuery("#mainframe").attr("height",height+"px");
        	jQuery("#mainframe").attr("src","views/system/anthorty/anthorty_show.jsp");
        </script>
    </div>

</div>


</body>
</html>