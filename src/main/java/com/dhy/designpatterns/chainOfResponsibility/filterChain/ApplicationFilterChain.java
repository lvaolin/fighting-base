package com.dhy.designpatterns.chainOfResponsibility.filterChain;

import javax.servlet.*;
import java.io.IOException;

public class ApplicationFilterChain implements FilterChain {
    /**
     * Filters.
     * 过滤器数组集合，初始数组大小为0，这就意味着后面定有扩容操作
     */
    private Filter[] filters = new Filter[0];

    /**
     * The int which is used to maintain the current position
     * in the filter chain.
     * 将要执行的过滤器指针（数组下标）
     */
    private int pos = 0;


    /**
     * The int which gives the current number of filters in the chain.
     * 过滤器链上过滤器的总数量
     */
    private int n = 0;

    // --------------------------------------------------------------

    //过滤器数组扩容容量增量值
    public static final int INCREMENT = 10;

    /**
     * The servlet instance to be executed by this chain.
     * 目标servlet，过滤器链执行完毕后直接调
     */
    private Servlet servlet = null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        internalDoFilter(request, response);
    }

    private void internalDoFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {

        // Call the next filter if there is one
        if (pos < n) {
            //继续执行下一个过滤器，注意pos的++ 操作，这个是过滤器链指针指向了下一个过滤器，为下一个过滤器的执行做好准备
            Filter filter = filters[pos++];
            try {
                //最后一个参数是关键
                //这里面并没有使用for循环把所有的过滤器调用一遍，
                //而是用了一个递归操作，通过传递当前FilterChain实例，将调用下下一个过滤器的决定权交给了下一个过滤器
                //如果不使用这种传递  链条 的方式的话， 在过滤器中就无法实现 性能计时监控 的功能了。
                filter.doFilter(request, response, this);
            } catch (IOException | ServletException | RuntimeException e) {
                throw e;
            } catch (Throwable e) {
                throw new ServletException("filterChain.filter", e);
            }
            //如果下一个过滤器忘记了向下传递，就会走到这里，意味着请求的中断
            //再也不会调到目标servlet了  😓
            return;
        }

        // We fell off the end of the chain -- call the servlet instance
        try {
            //出了 过滤器链，向下调用servlet实例方法
            servlet.service(request, response);
        } catch (IOException | ServletException | RuntimeException e) {
            throw e;
        } catch (Throwable e) {
            throw new ServletException("filterChain.servlet", e);
        } finally {

        }
    }


    /**
     * Add a filter to the set of filters that will be executed in this chain.
     * 向过滤器链上注册过滤器
     *
     * @param filterAdd The FilterConfig for the servlet to be executed
     */
    void addFilter(Filter filterAdd) {

        // Prevent the same filter being added multiple times
        //防止添加重复的过滤器
        for (Filter filter : filters) {
            if (filter == filterAdd) {
                return;
            }
        }


        //过滤器数组已满，进行扩容操作，默认新增10个容量
        if (n == filters.length) {
            Filter[] newFilters =
                    new Filter[n + INCREMENT];
            System.arraycopy(filters, 0, newFilters, 0, n);
            filters = newFilters;
        }
        //将新增的过滤器追加到过滤器链上，注意n++ ，它代表了当前实际存储的过滤器个数，因为数组不一定能填满，所以n来记录是有必要的
        filters[n++] = filterAdd;

    }

    /**
     * Set the servlet that will be executed at the end of this chain.
     * 设置目标servlet
     *
     * @param servlet The Wrapper for the servlet to be executed
     */
    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

}