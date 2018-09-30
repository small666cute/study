package com.servlet.action;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//测试复选框输入
public class CheckBox extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "读取复选框数据";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>smallcute：</b>: "
                + request.getParameter("smallcute") + "\n" +
                "  <li><b>Google：</b>: "
                + request.getParameter("google") + "\n" +
                "  <li><b>taobao：</b>: "
                + request.getParameter("taobao") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
