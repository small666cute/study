package com.servlet.action;

import javax.servlet.*;
import java.util.*;

public class LogFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        String site = config.getInitParameter("Site");
        System.out.println("logfilter init方法-网站名称：" + site);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
        System.out.println("logfilter dofilter方法-站点网址：http://www.smallcute.org");
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("filter destroy方法");
    }
}
