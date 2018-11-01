<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx}/static/lib/layui/css/layui.css">
<style type="text/css">
	.main_div{
		margin : 15px;
	}
</style>
</head>
<body>
  	<div class="main_div">
		<form id="form_add" onsubmit="return false" class="layui-form layui-form-pane" action="">
		  <div class="layui-form-item">
		    <label class="layui-form-label">角色名称</label>
		    <div class="layui-input-block">
		      <input type="text" name="name" autocomplete="off" placeholder="请输入标题" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">角色编号</label>
		    <div class="layui-input-block">
		      <input type="text" name="sn" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
			<label class="layui-form-label">权限</label>
			<div class="layui-input-block" id="permissions" name="permissions">
      	  </div>
		  <input type="button" class="layui-btn" onclick="submitForm()" value="提交"/>
		</form>
	</div>


	<script src="${ctx}/static/back/js/jquery.min.js"></script>
	<script src="${ctx}/static/common/mylayer.js"></script>
	<script src="${ctx}/static/common/util.js"></script>
	<script src="${ctx}/static/lib/layui/layui.js"></script>
	<script src="${ctx}/static/lib/kindeditor/kindeditor.js"></script>
	<script src="${ctx}/static/lib/kindeditor/lang/zh_CN.js"></script>
	<script>
	 	layui.config({
		    base : '${ctx}/static/lib/'
		  }).extend({
		    selectM: './layui_extends/selectM'
		  }).use(['form','upload','selectM'],function(){
		  	var form = layui.form;
		  	var upload = layui.upload;
		  	var selectM = layui.selectM;
		  	
		  	$.ajax({
				url : '${ctx}/permission/selectAllPermisssions.action',
				type : 'POST',
				dataType : 'json',
				success : function(resp) {
					if(resp.code == util.SUCCESS) {
						mylayer.success(resp.msg);
						
						 //多选标签-基本配置
					    var tagIns = selectM({
					      //元素容器【必填】
					      elem: '#permissions'
					      //候选数据【必填】
					      ,data: resp.data
					      //默认值
					      /* ,selected: [1,2] */
					      // 默认最多选中5个
					      ,max : 100
					    });
						 
					} else {
						mylayer.errorMsg(resp.msg);
					}
				}
			});
		});
		
		//ajax方式提交form表单
		function submitForm(){
			$.ajax({
				url : '${ctx}/role/add.action',
				data : $('#form_add').serialize(),
				type : 'POST',
				dataType : 'json',
				success : function(resp) {
					if(resp.code == util.SUCCESS) {
						//mylayer.success(jsonObj.msg);
						mylayer.confirm("添加成功，是够跳转到角色列表界面？", "${ctx}/role/getRolePage.action");
					} else {
						mylayer.errorMsg(resp.msg);
					}
				}
			});
		}
		
	</script>
</body>
</html>