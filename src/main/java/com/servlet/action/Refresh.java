package com.servlet.action;
import javax.servlet.*;
import java.util.*;
import java.io.*;
import java.text.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HTTP响应，这里是设置refresh参数
//这个refresh参数设置为5秒，那么这个页面会5秒刷新一次，这儿的网页是显示当前时间，所以是时间按5秒变大
public class Refresh extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        //设置自动刷新时间,refresh,为5秒
        response.setIntHeader("Refresh",5);
        response.setContentType("text/html;charset=UTF-8");
        //获得一个日历
        Calendar cale =Calendar.getInstance();
        //把calendar类型转换为date类型
        Date tasktime=cale.getTime();
        //设置日期输出的格式
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化输出
        String nowTime=df.format(tasktime);
        PrintWriter out=response.getWriter();
        String title="自动刷新refresh头设置";
        String docType="<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p>当前时间是：" + nowTime + "</p>\n");
    }
}
