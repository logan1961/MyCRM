package com.me.crm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.me.crm.entity.User;
import com.me.crm.util.UserContext;

public class LoginInterceptor implements HandlerInterceptor {
	
	/**
	 * 在controller处理前被调用，返回false的话拦截器请求就结束
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//从session中取出user
		User user = (User) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
		if (user != null) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath() + "/user/getLoginPage.action");
			return false;
		}
	}
	
	/**
	 * 只在preHandel返回是true的时候才运行，
	 * 是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，
	 * 也就是说在这个方法中你可以对ModelAndView进行操作。
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	
	/**
	 * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
