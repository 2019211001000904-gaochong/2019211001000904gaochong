package com.gaochong.controller;

import com.gaochong.dao.UserDao;
import com.gaochong.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "UpdateServlet", value = "/updateUser")//url
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //write code
        //TODO 1 : forward to WEB-INF/views/updateUser.jsp
        //TODO 2 : create one jsp page - update User
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //write code to update user info - canupdate password,email,gender,birthDate

        //TODO 1 : get all (6) request parameters
        //TODO 2 : create an object of User Model
        //TODO 3 : set all 6 request parameters values into User model - setXXX()
        //TODO 4 : create an object of UserDao
        //TODO 5 : Call updateUser() in UserDao
        //TODO 6 : forward to WEB-INF/views/userInfo.jsp
        int id=Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        Date birthdate = Date.valueOf(request.getParameter("birthdate"));
            Connection con = (Connection) getServletContext().getAttribute("con");
            User user=new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setGender(gender);
            user.setBirthdate(birthdate);
            UserDao userDao=new UserDao();

        try {
            int updateUser = userDao.updateUser(con,user);

        if(updateUser==1){
            request.getRequestDispatcher("/login").forward(request, response);
            }
            else {
                System.out.println("Fail");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
