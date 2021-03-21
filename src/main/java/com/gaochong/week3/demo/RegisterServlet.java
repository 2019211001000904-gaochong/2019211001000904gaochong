package com.gaochong.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

//automatic -new -->servlet
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// request com here- <from method=post>
        //get parameter from request .
        String username =request.getParameter("username");//name of input type -<input type="text" name="username"/><br/>
        String password =request.getParameter("password");//<input type="password" name="password"/>
        String email =request.getParameter("email");//<input type="text" name="email"/>
        String gender =request.getParameter("gender");//<input type="radio" name="gender">
        String birthDate =request.getParameter("birthDate");//<input type="text name=" name="birthDate">
        //print - write into response
        PrintWriter writer = response.getWriter();
        writer.println("username :"+username);
        writer.println("password :"+password);
        writer.println("email :"+email);
        writer.println("gender :"+gender);
        writer.println("birthDate :"+birthDate);
        writer.close();

    }
}
