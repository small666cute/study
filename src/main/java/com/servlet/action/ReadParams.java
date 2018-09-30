package com.servlet.action;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//这是用来读取所有表单数据的
public class ReadParams extends HttpServlet {
    public static final long serialVersionUID = 1L;

    public ReadParams() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String title = "读取所有的表单数据";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
                "transitional//en\">\n";
        out.append(docType +
                "<html>\n" +
                "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "<th>参数名称</th><th>参数值</th>\n" +
                "</tr>\n");
        //弄个枚举，把name都放进去，再遍历value
        Enumeration paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            out.print("<tr><td>" + paramName + "</td>\n");
            String[] paramValues = req.getParameterValues(paramName);
            if (paramValues.length == 1) {//只有一个值
                String paramValue = paramValues[0];
                if (paramValue.length() == 0)
                    out.append("<td><i>没有值</i><td>");
                else
                    out.append("<td>" + paramValue + "</td>");
            } else {//有多个值
                out.append("<td><ul>");
                for (int i = 0; i < paramValues.length; i++) {
                    out.append("<li>" + paramValues[i]);
                }
                out.append("</ul></td>");
            }
            out.append("</tr>");
        }
        out.append("\n</table>\n<body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

