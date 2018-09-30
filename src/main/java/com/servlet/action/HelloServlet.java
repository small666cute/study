package com.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void destroy() {

        System.out.println("这是destroy方法。。。。。");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("这是get servlet config方法。。。。。");
        return null;
    }

    @Override
    public String getServletInfo() {
        System.out.println("这是get servlet info方法");
        return null;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("这是init方法");
        message = "hello world";
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //String userName = req.getParameter("userName");
        System.out.println("这是service方法" );
        doGet(req,res);
        //throw new ServletException("test");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("这是do get方法");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.append("<h1>" + message + "</h1>");
    }
}
