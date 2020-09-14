package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wonzeng
 * @CreateTime: 2020-09-12
 */
@WebServlet(name = "LogoutServlet",urlPatterns = "/logout.ano")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("com.servlets.LogoutServlet.doPost()...");
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath()+"/index.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
