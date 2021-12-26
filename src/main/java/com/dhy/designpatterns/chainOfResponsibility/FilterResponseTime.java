package com.dhy.designpatterns.chainOfResponsibility;

import javax.servlet.*;
import java.io.IOException;

public class FilterResponseTime implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            long timeCost = System.currentTimeMillis() - start;
            System.out.println("耗时" + timeCost + "ms");
        }

    }


    @Override
    public void destroy() {
    }
}