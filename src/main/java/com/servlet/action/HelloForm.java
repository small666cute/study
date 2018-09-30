package com.servlet.action;

import java.io.*;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.http.*;

//这是个学习get 表单的类
public class HelloForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloForm() {
        super();
    }

    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应内容的类型，response是响应
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "使用POST方法读取表单数据";//"使用GET方法读取表单数据";
        //处理中文
        String name = new String(request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");
        String docType = "<!DOCTYPE html>\n";
        out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<u1>\n" + "<li><b>站点名</b>:"
                + name + "\n" + "<li><b>网址</b>:" + request.getParameter("url") + "\n" + "</ul>\n" + "</body></html>");
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie name = new Cookie("name", URLEncoder.encode(req.getParameter("name"), "UTF-8"));
        Cookie url = new Cookie("url", req.getParameter("url"));
        //设置超时时间
        name.setMaxAge(60 * 60);
        url.setMaxAge(60 * 60);
        resp.addCookie(name);
        resp.addCookie(url);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        String title="设置COOKIE练习";
        String docType="<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名：</b>："
                + req.getParameter("name") + "\n</li>" +
                "  <li><b>站点 URL：</b>："
                + req.getParameter("url") + "\n</li>" +
                "</ul>\n" +
                "</body></html>");
    }

    //处理post请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);//在dopost方法中调用doget方法，反过来也可以，需要怎么用就怎么调用
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "使用POST方法读取表单数据";//"使用GET方法读取表单数据";
        //处理中文
        String name = new String(request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");
        String docType = "<!DOCTYPE html>\n";
        out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<u1>\n" + "<li><b>站点名</b>:"
                + name + "\n" + "<li><b>网址</b>:" + request.getParameter("url") + "\n" + "</ul>\n" + "</body></html>");*/
        doGet(request,response);
    }
}