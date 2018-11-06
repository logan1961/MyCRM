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
		    <label class="layui-form-label">营销机会</label>
		    <div class="layui-input-block">
		      <input type="hidden" name="saleChanceId" value="${saleChanceId}">
		      <input type="text" name="name" autocomplete="off" placeholder="请输入营销机会" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">计划项</label>
		    <div class="layui-input-block">
		      <input type="text" name="planItem" lay-verify="required" placeholder="请输入计划项" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">执行效果</label>
		    <div class="layui-input-block">
		      <input type="text" name="exeAffect" lay-verify="required" placeholder="请输入效果" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <div class="layui-inline">
		      <label class="layui-form-label">计划日期</label>
		      <div class="layui-input-inline">
		        <input type="text" class="layui-input" name="planDate" id="date" placeholder="yyyy-MM-dd">
		      </div>
		    </div>
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
		  }).use(['form','laydate'],function(){
		  	var form = layui.form;
			var laydate = layui.laydate;
			
			laydate.render({
			    elem: '#date'
			  });
		});
		
		//ajax方式提交form表单
		function submitForm(){
			$.ajax({
				url : '${ctx}/cusDevPlan/addSaleChancePlan.action',
				data : $('#form_add').serialize(),
				type : 'POST',
				dataType : 'json',
				success : function(resp) {
					if(resp.code == util.SUCCESS) {
						mylayer.success(resp.msg);
						//关闭添加弹窗
						var index = parent.layer.getFrameIndex(window.name);
					    setTimeout(function(){
					    	//关闭弹窗
							parent.layer.close(index);
							//刷新父页面
					    	window.parent.location.reload();
							parent.layer.closeAll('iframe');
						},1000); 
					} else {
						mylayer.errorMsg(resp.msg);
					}
				}
			});
		}
	</script>
</body>
</html>