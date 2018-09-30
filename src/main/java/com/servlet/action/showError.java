package com.servlet.action;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

//回应错误页面
public class showError extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(407, "需要407");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
