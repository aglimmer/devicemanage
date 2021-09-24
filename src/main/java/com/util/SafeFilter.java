package com.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
//initParams存放初始化参数，在init中可以读取
//@WebFilter(filterName = "safeFilter",urlPatterns = {"/*"},
//        initParams = {@WebInitParam(name="charset",value="utf-8")})

public class SafeFilter implements Filter {

	public void destroy() {
	}

	HashSet<String> ignoreSet = null;


	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String servletPath = request.getServletPath();
		//System.out.println("servletPath=" + servletPath);
		//System.out.println("contextPath=" + request.getContextPath());
		//System.out.println("requestURI=" + request.getRequestURI());
		try {
			Object userid = request.getSession().getAttribute("userid");
			Object usertype = request.getSession().getAttribute("usertype");
			boolean isAllow = ignoreSet.contains(servletPath);
			//System.out.println("isAllow=" + isAllow);
			//可以匿名访问的路径放行，未包含在匿名路径中url且用户已经登录可以放行
			if (isAllow || (userid != null && usertype != null)) {
				filterChain.doFilter(servletRequest, servletResponse);
			} else {
				System.out.println("用户未登录，拦截当前请求路径：" + request.getContextPath() + servletPath);
				response.sendRedirect(request.getContextPath() + "/404.html");
			}
		}catch (Exception e){
			System.out.println("异常："+e.getMessage());
			e.printStackTrace();
		}
	}



		
/*
    不使用注解，则可以直接在web.xml配置：
    <filter>
       <filter-name>safeFileter</filter-name>
       <filter-class>com.bookstore.util.safeFilter</filter-class>
    </filter>
    <filter-mapping>
       <filter-name>safeFileter</filter-name>
       <url-pattern>/jsp</url-pattern>
    </filter-mapping>
*/

	//  可读取一些初始化参数
	@Override
    public void init(FilterConfig config) throws ServletException {
		System.out.println("config = " + config);
//        String filterName = config.getFilterName();
		//charset为自定义添加
//        String charset = config.getInitParameter("charset");
//        System.out.println("过滤器名称：" + filterName);
//        System.out.println("字符集编码：" + charset);
		String ignore = config.getInitParameter("ignore");
		ignoreSet = new HashSet<String>();
		ignoreSet.addAll(Arrays.asList(ignore.split(",")));
	}

}
