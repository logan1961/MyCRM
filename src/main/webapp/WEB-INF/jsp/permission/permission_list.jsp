<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ctx}/static/lib/layui/css/layui.css">
</head>
<body>
	<div class="demoTable">
	    名字：
	  <div class="layui-inline">
		  <input class="layui-input" id="searchName" />
	  </div>
	    副标题：
	  <div class="layui-inline">
		  <input class="layui-input" id="searchSubtitle" />
	  </div>
	   时间：
	  <div class="layui-inline">
		  <input class="layui-input" id="searchTime" />
	  </div>
	  <button class="layui-btn" data-type="search">搜索</button>
	  <button class="layui-btn" data-type="deleteAll">批量删除</button>
	  <button class="layui-btn" data-type="add">添加</button>
	</div>
	<table id="tableId" lay-filter="tableFilter"></table>

	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script type="text/html" id="statusTpl">
		 {{#  if(d.status == 1){  }}
		 	           上架
		 {{#  } else {            }}
				  下架
		 {{#  }					  }}
	</script>
	<script type="text/html" id="mainImageTpl">
		 <img src="{{d.fullUrl}}"/>
	</script>
	
	<script src="${ctx}/static/back/js/jquery.min.js"></script>
	<script src="${ctx}/static/common/mylayer.js"></script>
	<script src="${ctx}/static/common/util.js"></script>
	<script src="${ctx}/static/lib/layui/layui.js"></script>
	<script>
		layui.use(['table','laydate'], function() {
			var table = layui.table;
			var laydate = layui.laydate;
			
			//执行一个laydate实例
			laydate.render({
			   elem: '#searchTime' //指定元素
			});
			
			table.render({
			    elem: '#tableId'
			    ,url: '${ctx}/permission/pageList.action' //数据接口
			    ,page: true //开启分页
			    ,id : "layUITableId" //设定容器唯一ID，id值是对表格的数据操作方法上是必要的传递条件，它是表格容器的索引
			    ,cols: [[ //表头
			      {type: 'checkbox', fixed: 'left'}
			      ,{field: 'id', title: 'ID',  sort: true, fixed: 'left'}
			      ,{field: 'name', title: '权限名称', sort: true, fixed: 'left'}
			      ,{field: 'resource', title: '资源', sort: true, fixed: 'left'}
			      ,{field: 'createTime', title: '创建时间', sort: true}
			      ,{field: 'updateTime', title: '更新时间', sort: true}
			      ,{fixed:'right', width: 178, toolbar:'#barDemo'}
			    ]]
			  });
			
		  //监听工具条
		  //tool是工具条事件名，tableFilter是table容器属性lay-filter="tableFilter"对应的值
		  table.on('tool(tableFilter)', function(obj){
		    var data = obj.data;//获得当前行数据,json格式对象
		    var layEvent = obj.event;//获得lay-event对应的值
		    if(layEvent === 'detail'){
		      layer.msg('ID：'+ data.id + ' 的查看操作');
		    } else if(layEvent === 'del'){
		      layer.confirm('真的删除行么', function(index){
		    	$.ajax({
		    		url:"${ctx}/permission/deleteById.action",
		    		data:{"id":data.id},
		    		dataType:"json",
		    		success:function(resp) {
		    			if(resp.code == util.SUCCESS){
		    				mylayer.success(resp.msg);
		    				table.reload("layUITableId");
		    			} else {
		    				mylayer.errorMsg(resp.msg);
		    			}
			        layer.close(index);
		    		}
		    	});
		      });
		    } else if(obj.event === 'edit'){
				location.href = "${ctx}/permission/getUpdatePage.action?id=" + data.id;
		    }
		  });
		  
		  var active = {
		    deleteAll: function(){ //获取选中数据
		       var checkStatus = table.checkStatus('layUITableId')
		       var data = checkStatus.data;
		       console.log(data);//选中行的数据
		       console.log(checkStatus.data.length);//获取选中行的数量
		       console.log(checkStatus.isAll);//表格是否全选
		       var ids = util.getSelectedIds(data);
		       console.log(ids);
		       layer.confirm('真的删除行么', function(index){
			    	$.ajax({
			    		url:"${ctx}/permission/deleteAll.action",
			    		data:{"ids":ids},
			    		dataType:"json",
			    		success:function(resp) {
			    			if(resp.code == util.SUCCESS){
			    				mylayer.success(resp.msg);
			    				table.reload("layUITableId");
			    			} else {
			    				mylayer.errorMsg(resp.msg);
			    			}
				        layer.close(index);
			    		}
			    	});
			   });
		    },
		    //搜索
			search : function() {
				table.reload('layUITableId', {
				  where: { //设定异步数据接口的额外参数，任意设
					  name:$("#searchName").val(),
					  subtitle:$("#searchSubtitle").val(),
					  time:$("#searchTime").val()
				  }
				  ,page: {
				    curr: 1 //重新从第 1 页开始
				  }
				});
			},
			//添加
			add : function() {
				location.href = "${ctx}/permission/getAddPage.action";
			}
		  };
		  
		  $('.demoTable .layui-btn').on('click', function(){
			   var type = $(this).data('type');
			   active[type] ? active[type].call(this) : '';
		   });
		});
	</script>
</body>
</html>