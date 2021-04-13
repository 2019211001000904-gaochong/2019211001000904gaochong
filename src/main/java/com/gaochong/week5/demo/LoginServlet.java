package com.gaochong.week5.demo;

import com.microsoft.sqlserver.jdbc.ISQLServerConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    Connection con = null;

    @Override
    public void init() throws ServletException {
/*        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con=(Connection) getServletContext().getAttribute("con");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);// call dopost
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        try {
            Statement createDbStatement = con.createStatement();//用连接connection，创建Statement对象createDbStatement，指定结果集可以滚动，并且以只读方式读取数据库。
            String selectDb = "select * from usertable where username='"+username+"' and password='"+password+"'";
            ResultSet rs = createDbStatement.executeQuery(selectDb);
            if(rs.next()){
                //week 5 code
                //writer.println("Login Success!!!");
                //writer.println("Welcome"+username);
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }else{
                //writer.println("Username or Password Error!!!");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
