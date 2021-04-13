package com.gaochong.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt=request.getParameter("txt");
        String search=request.getParameter("search");
        if(txt==null || txt.trim().equals("")){
            response.sendRedirect("index.jsp");
        }else{
            if(search.equals("Baidu")){
                response.sendRedirect("https://www.baidu.com");
                return;
            }else if(search.equals("Bing")){
                response.sendRedirect("https://www.bing.com");
                return;
            }else if(search.equals("Google")){
                response.sendRedirect("https://www.google.com");
                return;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
