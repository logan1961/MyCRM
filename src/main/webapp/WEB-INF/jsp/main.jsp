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
	<h2>欢迎使用后台管理系统</h2>
	<h3>当前登录用户:</h3>
	<a href="${ctx}/user/logout.action"><input type="button" value="退出" onclick="logout()"/></a>
	<div id="main" style="width: 600px;height:400px;"></div>
</body>
<script type="text/javascript" src="${ctx}/static/lib/echarts.min.js"></script>
<script>
    // 绘制图表。
    echarts.init(document.getElementById('main')).setOption({
        series: {
            type: 'pie',
            data: [
                {name: '欢迎', value: 1212},
                {name: '你好', value: 2323},
                {name: '来了老弟', value: 1919},
                {}
            ]
        }
    });
</script>
<script type="text/javascript">
	function logout(){
		location.href="${ctx}/user/logout.action";
		window.location.reload();
	}
</script>
</html>