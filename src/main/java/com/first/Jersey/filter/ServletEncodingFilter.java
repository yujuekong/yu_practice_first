package com.first.Jersey.filter;

import com.google.inject.Singleton;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by yujuekong on 2017/7/6.
 * guice中的过滤器必须加上@Singleton
 */
@Singleton
public class ServletEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("this is ServletFilter");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
