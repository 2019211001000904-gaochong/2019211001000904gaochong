package com.lab2;

import javax.servlet.*;
import java.io.IOException;

public class GaochongFilter implements Filter {
    public void destroy() {
    }
    public void init(FilterConfig config) throws ServletException {

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("GcFilter -- before chain");
        chain.doFilter(req, resp);
        System.out.println("GcFilter -- after chain");
    }

}
