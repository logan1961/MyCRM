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
		<form id="form_add" class="layui-form layui-form-pane" action="">
		  <div class="layui-form-item">
		    <label class="layui-form-label">机会来源</label>
		    <div class="layui-input-block">
		      <input type="text" name="chanceSource" autocomplete="off" placeholder="请输入标题" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">所属客户</label>
		    <div class="layui-input-block">
		    	<select name="customerId">
		    		<option value="">--选择客户--</option>
		    		<c:forEach items="${customerList}" var="customer">
		    			<option value="${customer.id}">${customer.name}</option>
		    		</c:forEach>
		    	</select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">意向产品</label>
		    <div class="layui-input-block">
		    	<select name="productId">
		    		<option value="">--选择客户--</option>
		    		<c:forEach items="${productList}" var="product">
		    			<option value="${product.id}">${product.name}</option>
		    		</c:forEach>
		    	</select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">指派营销人员</label>
		    <div class="layui-input-block">
		    	<select name="userId">
		    		<option value="">--选择客户--</option>
		    		<c:forEach items="${userList}" var="user">
		    			<option value="${user.id}">${user.name}</option>
		    		</c:forEach>
		    	</select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">成功几率</label>
		    <div class="layui-input-inline">
		      <input type="text" name="successRate" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">机会描述</label>
		    <div class="layui-input-inline">
		      <input type="text" name="description" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">创建人</label>
		    <div class="layui-input-inline">
		      <input type="text" value="${user.name}" name="createMan" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		</form>
		<button class="layui-btn" onclick="submitForm()">添加</button>
	</div>


	<script src="${ctx}/static/back/js/jquery.min.js"></script>
	<script src="${ctx}/static/common/mylayer.js"></script>
	<script src="${ctx}/static/common/util.js"></script>
	<script src="${ctx}/static/lib/layui/layui.js"></script>
	<script src="${ctx}/static/lib/kindeditor/kindeditor.js"></script>
	<script src="${ctx}/static/lib/kindeditor/lang/zh_CN.js"></script>
	<script>
		layui.use(['form'], function(){
		  var form = layui.form;
		  
		});
		
		//ajax方式提交form表单
		function submitForm(){
			$.ajax({
				url : '${ctx}/saleChance/add.action',
				data : $('#form_add').serialize(),
				type : 'POST',
				dataType : 'json',
				success : function(resp) {
					if(resp.code == util.SUCCESS) {
						//mylayer.success(jsonObj.msg);
						mylayer.confirm("添加成功，是够跳转到商品列表界面？", "${ctx}/saleChance/getSaleChancePage.action");
					} else {
						mylayer.errorMsg(resp.msg);
					}
				}
			});
		}
		
	</script>
</body>
</html>