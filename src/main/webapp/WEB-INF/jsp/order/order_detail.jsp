<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title></title>
	<link rel="stylesheet" type="text/css" href="${ctx}/static/back/css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="${ctx}/static/back/css/main.css"/>
</head>
<body>
	<h3 class="common_title">订单详情</h3>
	
	<div class="common_list_con clearfix">
		<ul class="goods_list_th clearfix">
			<li class="col01">顾客ID</li>
			<li class="col02">订单编号</li>
			<li class="col03">saleChanceID</li>
			<li class="col04">状态</li>
			<li class="col05">商品ID</li>
			<li class="col06">订单时间</li>
		</ul>
		<ul class="goods_list_td clearfix">
			<li class="col01">${order.customerId}</li>			
			<li class="col02">${order.orderNo}</li>
			<li class="col03">${order.saleChanceId}</li>
			<li class="col04">${order.status}</li>
			<li class="col05">${order.productId}</li>
			<li class="col06">${order.orderDate}</li>
		</ul>
	</div>
	<script type="text/javascript" src="${ctx}/static/back/js/jquery.min.js"></script>
	<script type="text/javascript">
		$('#order_btn').click(function() {
			localStorage.setItem('order_finish',2);

			$('.popup_con').fadeIn('fast', function() {

				setTimeout(function(){
					$('.popup_con').fadeOut('fast',function(){
						window.location.href = 'index.html';
					});	
				},3000)
				
			});
		});
	</script>
</body>
</html>