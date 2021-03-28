package com.gaochong.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//use @WebServlet - no web.xml code
@WebServlet(
        urlPatterns = {"/config"},
        initParams ={
                @WebInitParam(name = "name", value = "gaochong"),
                @WebInitParam(name = "studentId", value = "2019211001000904")
        }
)
public class ConfigDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getServletConfig().getInitParameter("name");
        String studentId = getServletConfig().getInitParameter("studentId");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<br/>name:" + name);
        writer.println("<br/>studentId:" + studentId);
    }
}
