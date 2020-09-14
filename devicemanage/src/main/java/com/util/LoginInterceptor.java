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
    //在目标方法运行之前工作，返回true表示放行，否则不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("com.util.LoginInterceptor.preHandle()");
//        System.out.println("urlPath="+request.getRequestURI());
        Object userid = request.getSession().getAttribute("userid");
        Object usertype = request.getSession().getAttribute("usertype");
//        System.out.println("userid="+userid+",usertype="+usertype);
//        已经登录
        if(userid!=null && usertype!=null){
            System.out.println("处于登录状态...");
            return true;
        }else{
            System.out.println("未处于登录状态...");
            response.sendRedirect(request.getContextPath() + "/index.html");
            return false;
        }
//        return true;
    }
    //目标方法运行之后，返回之前工作
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle()...");
    }
    //在整个请求完成，来到目标页面之后工作
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        System.out.println(" afterCompletion()...");
    }


}
