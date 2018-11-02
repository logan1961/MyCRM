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
		    <label class="layui-form-label">产品名称</label>
		    <div class="layui-input-block">
		      <input type="text" name="name" autocomplete="off" placeholder="请输入产品名称" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">单位</label>
		    <div class="layui-input-block">
		      <input type="text" name="unit" lay-verify="required" placeholder="请输入单位" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">价格</label>
		    <div class="layui-input-block">
		      <input type="text" name="price" lay-verify="required" placeholder="请输入价格" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">库存</label>
		    <div class="layui-input-block">
		      <input type="text" name="stock" lay-verify="required" placeholder="请输入库存" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">图片</label>
		    <!-- 隐藏的标签，目的是提交表单时将图片的信息传到数据库 -->
		    <input type="hidden" name="image" id="mainImage"/>
		    <div class="layui-upload">
			  <button type="button" class="layui-btn" id="uploadImgBtn">上传图片</button>
			  <div class="layui-upload-list">
			    <img style="width:200px;height:200px" class="layui-upload-img" id="mainImg">
			    <p id="demoText"></p>
			  </div>
			</div>   
		  </div>
		  <div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">详情</label>
		    <div class="layui-input-block">
		      <textarea id="editor_id" name="detail" style="height:500px" placeholder="请输入内容" class="layui-textarea"></textarea>
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
		  }).use(['form','upload'],function(){
		  	var form = layui.form;
		  	var upload = layui.upload;
		  	
		  	//上传图片
	  	 	var uploadInst = upload.render({
			    elem: '#uploadImgBtn'
			    ,url: '${ctx}/upload/uploadImg.action'
			    ,before: function(obj){
			      //预读本地文件示例，不支持ie8
			      obj.preview(function(index, file, result){
			        $('#mainImg').attr('src', result); //图片链接（base64）
			      });
			    }
			    ,done: function(resp){
			       if(resp.code == util.SUCCESS) {
			    	   //给这个隐藏标签填上value值<input type="hidden" name="mainImage" id="mainImage"/>
			    	   $("#mainImage").val(resp.data);
			       }
			    }
			    ,error: function(){
			      //演示失败状态，并实现重传
			      var demoText = $('#demoText');
			      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
			      demoText.find('.demo-reload').on('click', function(){
			        uploadInst.upload();
			      });
			    }
		    });
		});
		
		//ajax方式提交form表单
		function submitForm(){
			$.ajax({
				url : '${ctx}/product/add.action',
				data : $('#form_add').serialize(),
				type : 'POST',
				dataType : 'json',
				success : function(resp) {
					if(resp.code == util.SUCCESS) {
						//mylayer.success(jsonObj.msg);
						mylayer.confirm("添加成功，是否跳转到产品列表界面？", "${ctx}/product/getProductPage.action");
					} else {
						mylayer.errorMsg(resp.msg);
					}
				}
			});
		}
		
		//富文本编辑器
		var myKindEditor ;
        KindEditor.ready(function(K) {
            var kingEditorParams = {
                 //指定上传文件参数名称
                 filePostName  : "file",
                 //指定上传文件请求的url。
                 uploadJson : '${ctx}/upload/uploadImgByEditor.action',
                 //上传类型，分别为image、flash、media、file
                 dir : "image",
                 afterBlur: function () { this.sync(); }
           }
          var editor = K.editor(kingEditorParams);
          
         //富文本编辑器
         myKindEditor = KindEditor.create('#form_add[name=detail]', kingEditorParams);
       });
	</script>
</body>
</html>