package com.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//initParams存放初始化参数，在init中可以读取
//@WebFilter(filterName = "safeFilter",urlPatterns = {"/*"},
//        initParams = {@WebInitParam(name="charset",value="utf-8")})

public class SafeFilter implements Filter {

	public void destroy() {
	}

	HashSet<String> ignoreSet = null;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

//		String contextPath=request.getContextPath();
//		String servletPath = request.getServletPath();
//		String requestURI = request.getRequestURI();
//		System.out.println("contextPath="+contextPath+"\nservletPath="+servletPath+"\nrequestURI="+requestURI);

		String urlPath = request.getServletPath();
		Object userid = request.getSession().getAttribute("userid");
		Object usertype = request.getSession().getAttribute("usertype");
//		System.out.println("urlpath="+urlPath);
//		System.out.println("ignoreSet = " + ignoreSet);
		System.out.println(ignoreSet.contains(urlPath));
//		可以匿名访问的路径放行，未包含在匿名路径中url且用户已经登录可以放行
		if (ignoreSet.contains(urlPath) || (userid != null && usertype != null)) {
//			System.out.println("过滤器放行...");
//			System.out.println("userid="+userid+" ,usertype="+usertype);
			filterChain.doFilter(servletRequest, servletResponse);
		}else{
//			System.out.println("过滤器不放行...");
			System.out.println(request.getContextPath() + "/index.html");
			response.sendRedirect(request.getContextPath() + "/index.html");
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
        public void init (FilterConfig config) throws ServletException
        {
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
