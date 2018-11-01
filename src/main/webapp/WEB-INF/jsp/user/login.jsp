<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>	
<head>
<title>登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> 
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0); 
		}, false);
		function hideURLbar(){
			window.scrollTo(0,1);
		} 
</script>
<meta name="keywords" content="Kipy Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="${ctx }/static/back/css/style2.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:700,300,600,800,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Marvel:400,700' rel='stylesheet' type='text/css'>
</head>
<body>
<h1>欢迎使用</h1>
	<div class="login-form">
		<h2>User Login</h2>
			<div class="form-info">
					<form id="login_form">
							<input type="text" id="name" name="name" class="username" placeholder="UserName" />
							<input type="text" id="password" name="password" class="password" placeholder="Password" />
							<p><a href="#">忘记密码 ? </a></p>
						<ul class="login-buttons">
							<!-- <li><a href="#" class="hvr-sweep-to-left">注册</a></li> -->
							<!-- <div class="clear"> </div> -->
						</ul>
					</form>
					<li"><input type="submita" value="登录" onclick="submitForm()"/></li>
			</div>
	</div>
<!--copyrights-->
<div class="copyrights">
	<p>Template by <a href="http://loganwz.com">© logan_w </a></p>
</div>
<!--/copyrights-->

	<script type="text/javascript" src="${ctx}/static/back/js/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/common/mylayer.js"></script>
	<script type="text/javascript" src="${ctx}/static/lib/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx}/static/common/util.js"></script>
	<script type="text/javascript">
		//一般直接写在一个js文件中
		layui.use(['layer'], function(){
		  var layer = layui.layer;
		});
	</script>
	<script type="text/javascript">
		function submitForm(){
			/* 1、验证用户名
			1.1、用户名不能为空
			1.2、是否合法：5-10位数字或字母
			2、密码不能为空
			3、ajax提交用户名和密码，根据后台返回的ServerResponse决定进行什么操作 */
			var name = $("#name").val();
			var password = $("#password").val();
			// 1.1、用户名不能为空
			if(util.isNull(name)) {
				mylayer.errorMsg("用户名不能为空");
				return;
			}
			// 1.2、是否合法：5-10位数字或字母
			var pattern = /^[0-9a-zA-Z]{3,10}$/;
			if(!pattern.test(name)) {
				mylayer.errorMsg("格式非法，请输入3-10位数字或字母");
				return;
			}
			//2、密码不能为空
			if(util.isNull(password)) {
				mylayer.errorMsg("密码不能为空");
				return;
			}
			
			//3、ajax提交用户名和密码，根据后台返回的ServerResponse决定进行什么操作
			$.ajax({
				url:"${ctx}/user/login.action",
				type:"POST",
				dataType:"json",
				data:$("#login_form").serialize(),
				success:function(resp) {
					console.log(resp);
					if(resp.code == util.SUCCESS){
						mylayer.successUrl(resp.msg, "${ctx}/index.action");
					} else {
						mylayer.errorMsg(resp.msg);
					}
				}
			});
		}
	</script>
</body>
</html>