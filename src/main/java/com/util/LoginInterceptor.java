package com.util;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-09-12
 */
public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * 在目标方法运行之前工作，返回true表示放行，否则不放行
	 **/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object userid = request.getSession().getAttribute("userid");
		Object usertype = request.getSession().getAttribute("usertype");
		//System.out.println("userid="+userid+",usertype="+usertype);
		//已经登录
		if (userid != null && usertype != null) {
			return true;
		} else {
			System.out.println("用户未经过登录，无法从session获取用户信息");
			//转发到指定页面
			//request.getRequestDispatcher(request.getContextPath() + "/404.html").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/404.html");
			return false;
		}
	}

	//目标方法运行之后，返回之前工作
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle()...");
	}

	/**
	 * 在整个请求完成，来到目标页面之后工作
	 **/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //System.out.println(" afterCompletion()...");
	}


}
