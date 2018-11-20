<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="main" style="width: 600px;height:400px;"></div>
</body>
<script src="${ctx}/static/back/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/lib/echarts.min.js"></script>
<script type="text/javascript">
	$(function(){
		//初始化Echarts实例
		var myChart = echarts.init(document.getElementById('main'));
		
		$.ajax({
			url : "${ctx}/product/getProductCount.action",
			type : "POST",
			dataType : "json",
			success : function(resp) {
				console.log(resp);
				var data = resp.data;
				//x轴，存放分类名称
				var xArray = new Array();
				//y轴，存放每类的数量
				var yArray = new Array();
				for(var i = 0; i < data.length;i++) {
					xArray.push(data[i].name);
					yArray.push(data[i].stock)
				}
				console.log(xArray);
				console.log(yArray);
				//图表配置项和数据
				option = {
					title: {
						text: '商品分类统计'
					},
					tooltip:{},
					legend:{
						data:['分类数量']
					},
				    xAxis: {
				        data: xArray
				    },
				    yAxis: {
				        
				    },
				    series: [{
				    	name: '库存',
				        data: yArray,
				        type: 'bar'
				    }]
				};
				
				//使用刚指定的配置项和数据显示图表
				myChart.setOption(option);
			}
		});
	});
</script>
</html>