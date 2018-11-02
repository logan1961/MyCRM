<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>
<%@taglib uri="http://me.com/rbac" prefix="myFn"  %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>CRM后台管理系统</title>

    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${ctx}/static/back/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx}/static/back/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx}/static/back/css/animate.css" rel="stylesheet">
    <link href="${ctx}/static/back/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <strong style="margin-left:12px" class="font-bold">CRM管理系统</strong>
                                    </span>
                                </span>
                            </a>
                        </div>
                        <div class="logo-element">logan
                        </div>
                    </li>
                    <li class="line dk"></li>
                    <li class="J_menuItem">
                        <a class="J_menuItem" href="${ctx}/user/logout.action">
                            <i class="fa"></i>
                            <span class="nav-label" style="margin-left:0px">用户退出</span>
                        </a>
                    </li>
                    <li class="line dk"></li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">分类</span>
                    </li>
                    <li>
                        <a class="J_menuItem" href="${ctx}/getHomePage.action">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">主页</span>
                        </a>
                    </li>
                    <c:if test="${myFn:checkPermission('spgl:/product/getPrductPage.action')}">
	                    <li>
	                        <a class="J_menuItem" href="${ctx}/product/getProductPage.action">
	                            <i class="fa fa-desktop"></i>
	                            <span class="nav-label">商品管理</span>
	                        </a>
	                    </li>
                    </c:if>
                    <c:if test="${myFn:checkPermission('yxgl:/saleChance/getSaleChancePage.action') }">
	                    <li>
	                        <a class="J_menuItem" href="${ctx}/saleChance/getSaleChancePage.action">
	                            <i class="fa fa-desktop"></i>
	                            <span class="nav-label">营销管理</span>
	                        </a>
	                    </li>
                    </c:if> 
                    <c:if test="${myFn:checkPermission('ddgl:/order/getOrderPage.action') }">
	                    <li>
	                        <a class="J_menuItem" href="${ctx}/srder/getOrderPage.action">
	                            <i class="fa fa-desktop"></i>
	                            <span class="nav-label">订单管理</span>
	                        </a>
	                    </li>
                    </c:if>
                    <c:if test="${myFn:checkPermission('tjtb')}">
	                    <li>
	                        <a href="#">
	                            <i class="fa fa fa-edit"></i>
	                            <span class="nav-label">统计图表</span>
	                            <span class="fa arrow"></span>
	                        </a>
	                        <ul class="nav nav-second-level">
	                        	<c:if test="${myFn:checkPermission('tjtb:/charts/getProductAmount.action')}">
		                            <li>
		                                <a class="J_menuItem" href="${ctx}/product/getProductsPage.action">商品数量统计</a>
		                            </li>
		                        </c:if>
		                        <c:if test="${myFn:checkPermission('tjtb:/charts/getProductSale.action')}">
		                            <li>
		                                <a class="J_menuItem" href="${ctx}/user/getUserPage.action">商品销量统计</a>
		                            <li>
	                        	</c:if>
	                        </ul>
	                    </li>
                    </c:if>
                    <c:if test="${myFn:checkPermission('yhqx')}">
	                    <li>
	                        <a href="#">
	                            <i class="fa fa fa-bar-chart-o"></i>
	                            <span class="nav-label">用户&权限管理</span>
	                            <span class="fa arrow"></span>
	                        </a>
	                        <ul class="nav nav-second-level">
	                        	<c:if test="${myFn:checkPermission('yhqx:/user/getUserPage.action')}">
	                            	<li>
		                                <a class="J_menuItem" href="${ctx}/user/getUserPage.action">用户管理</a>
		                            </li>
	                        	</c:if>
	                            <c:if test="${myFn:checkPermission('yhqx:/user/getRolePage.action')}">
		                            <li>
		                                <a class="J_menuItem" href="${ctx}/role/getRolePage.action">角色管理</a>
		                            <li>
	                            </c:if>
	                            <c:if test="${myFn:checkPermission('yhqx:/user/getPermissionPage.action')}">
		                            <li>
		                                <a class="J_menuItem" href="${ctx}/permission/getPermissionPage.action">权限管理</a>
		                            </li>
	                            </c:if>
	                        </ul>
	                    </li>
                    </c:if>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>
                        <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                            <div class="form-group">
                                <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                            </div>
                        </form>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <i class="fa fa-envelope"></i> <span class="label label-warning">16</span>
                            </a>
                            <ul class="dropdown-menu dropdown-messages">
                                <li class="m-t-xs">
                                    <div class="dropdown-messages-box">
                                        <a href="profile.html" class="pull-left">
                                            <img alt="image" class="img-circle" src="${ctx }/static/back/img/a7.jpg">
                                        </a>
                                        <div class="media-body">
                                            <small class="pull-right">46小时前</small>
                                            <strong>小四</strong> 是不是只有我死了,你们才不骂爵迹
                                            <br>
                                            <small class="text-muted">3天前 2014.11.8</small>
                                        </div>
                                    </div>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="dropdown-messages-box">
                                        <a href="profile.html" class="pull-left">
                                            <img alt="image" class="img-circle" src="${ctx }/static/back/img/a4.jpg">
                                        </a>
                                        <div class="media-body ">
                                            <small class="pull-right text-navy">25小时前</small>
                                            <strong>二愣子</strong> 呵呵
                                            <br>
                                            <small class="text-muted">昨天</small>
                                        </div>
                                    </div>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="text-center link-block">
                                        <a class="J_menuItem" href="mailbox.html">
                                            <i class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
                            </a>
                            <ul class="dropdown-menu dropdown-alerts">
                                <li>
                                    <a href="mailbox.html">
                                        <div>
                                            <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                                            <span class="pull-right text-muted small">4分钟前</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="profile.html">
                                        <div>
                                            <i class="fa fa-qq fa-fw"></i> 3条新回复
                                            <span class="pull-right text-muted small">12分钟钱</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="text-center link-block">
                                        <a class="J_menuItem" href="notifications.html">
                                            <strong>查看所有 </strong>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe id="J_iframe" width="100%" height="100%" src="${ctx}/getHomePage.action" frameborder="0" data-id="index_v1.html" seamless></iframe>
            </div>
        </div>
        <!--右侧部分结束-->
    </div>

    <!-- 全局js -->
    <script src="${ctx}/static/back/js/jquery.min.js?v=2.1.4"></script>
    <script src="${ctx}/static/back/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${ctx}/static/back/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="${ctx}/static/back/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${ctx}/static/back/js/plugins/layer/layer.min.js"></script>

    <!-- 自定义js -->
    <script src="${ctx}/static/back/js/hAdmin.js?v=4.1.0"></script>
    <script type="text/javascript" src="${ctx}/static/back/js/index.js"></script>

    <!-- 第三方插件 -->
    <script src="${ctx}/static/back/js/plugins/pace/pace.min.js"></script>

</body>

</html>