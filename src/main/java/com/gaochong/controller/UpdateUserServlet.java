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

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Integer id = Integer.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        java.util.Date birthDate = null;
        try {
            birthDate = simpleDateFormat.parse(request.getParameter("birthDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthdate(birthDate);

        UserDao userDao = new UserDao();
        Connection con = (Connection) getServletContext().getAttribute("con");
        try {
            int index = userDao.updateUser(con, user);
            request.getSession().setAttribute("user",userDao.findById(con,id));
            if(index!=0) {
                request.getRequestDispatcher("accountDetails").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }
}
