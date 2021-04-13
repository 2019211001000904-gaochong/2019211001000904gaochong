package com.gaochong.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
     Connection con=null;

    public void init() throws ServletException{
/*        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con=(Connection) getServletContext().getAttribute("con");
        System.out.println(con);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String birthdate = request.getParameter("birthdate");
            PrintWriter out = response.getWriter();
            try {
                Statement st = con.createStatement();
                String insertDb = "insert into userdb.dbo.usertable(username,password,email,gender,birthdate)" + "values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthdate+"')";
                System.out.println("insertDb"+insertDb);
                int n =st.executeUpdate(insertDb);
                System.out.println("n-->"+n);//==1 success --insert
               // String selectDb = "select id,username,password,email,gender,birthdate from userdb.dbo.usertable";
               // ResultSet rs = st.executeQuery(selectDb);
              /*  out.println("<html><title></title><body><table border=1><tr>");
                out.println("<td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthday</td><tr/>");
                while(rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("username") + "</td>");
                    out.println("<td>" + rs.getString("password") + "</td>");
                    out.println("<td>" + rs.getString("email") + "</td>");
                    out.println("<td>" + rs.getString("gender") + "</td>");
                    out.println("<td>" + rs.getString("birthdate") + "</td>");
                    out.println("</tr>");
                }
                out.println("</table></body></html>");*/
                //use request attribute
                //set rs into request attribute
               /* request.setAttribute("rsname",rs);//name -string , value - any type (object)

                request.getRequestDispatcher("userList.jsp").forward(request,response);//at this point request given to userList
                //no more here
                System.out.println("i am RegisterServlet -->doPost()--> after forward()");//no see this line*/

                //ok -done
                //after register a new user - user can login
                response.sendRedirect("login.jsp");
            } catch (Exception e) {
                System.out.println(e);
            }
            out.println("</table>");

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
