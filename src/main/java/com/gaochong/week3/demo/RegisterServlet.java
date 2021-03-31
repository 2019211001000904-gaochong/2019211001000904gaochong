package com.gaochong.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public Connection con;

    public void init() throws ServletException{
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        PrintWriter writer = response.getWriter();
        try {

            System.out.println("con:"+con);
            Statement createDbStatement = con.createStatement();
            String insertDb = "insert into usertable(username,password,email,gender,birthDate) values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthDate+"')";
            createDbStatement.executeUpdate(insertDb);
            String selectDb = "select * from usertable";
            ResultSet rs = createDbStatement.executeQuery(selectDb);
            while(rs.next()) {
                rs.getString("id");
                rs.getString("userName");
                rs.getString("password");
                rs.getString("email");
                rs.getString("gender");
                rs.getString("birthDate");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        writer.println(
                "<table border=\"1\">"       +
                        "<tr>"                   +
                        "<td>id</td>"        +
                        "<td>userName</td>"  +
                        "<td>password</td>"  +
                        "<td>email</td>"     +
                        "<td>gender</td>"    +
                        "<td>birthDate</td>" +
                        "</tr>"    +
                        "<tr>"     +
                        "<td>" + id        + "</td>" +
                        "<td>" + username  + "</td>" +
                        "<td>" + password  + "</td>" +
                        "<td>" + email     + "</td>" +
                        "<td>" + gender    + "</td>" +
                        "<td>" + birthDate + "</td>" +
                        "</tr>"    +
                        "</table>");
    }









/*        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        PrintWriter writer = response.getWriter();
        writer.println("username :" + username);
        writer.println("password :" + password);
        writer.println("email :" + email);
        writer.println("gender :" + gender);
        writer.println("birthDate :" + birthDate);
        writer.close();*/
}
