package com.gaochong.week5.demo;

import com.gaochong.dao.UserDao;
import com.gaochong.model.User;
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
        super.init();
        con=(Connection) getServletContext().getAttribute("con");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);// call dopost
//when use click menu LOGIN-request is get
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);//check jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                //valid
                //week 8 code
                //add code for remember me
                String rememberMe=request.getParameter("rememberMe");//1=checked,null if checked
                if(rememberMe!=null&&rememberMe.equals("1")){
                    //want to remember me
                    //create 3 cookies
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                    //set age of cookies
                    usernameCookie.setMaxAge(500);//5 sec for - test --- 15 days = 60*60*24*15
                    passwordCookie.setMaxAge(500);
                    rememberMeCookie.setMaxAge(500);
                    //add 3 cookies into response
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                //create a session
                HttpSession session=request.getSession();//create a new session if session does not exist - otherwise return existing session
                //check session id
                System.out.println("session if -->"+session.getId());//session id
                //set time for session
                session.setMaxInactiveInterval(10);//for 5 10 section if request not come in - tomcat kill session - set 60*60 ==1h

                //set user model into request
                //week 8 0- change request(one page) to session - so we can get session attribute in many jsp page
                session.setAttribute("user",user);
                //request.setAttribute("user",user)
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
/*        try {
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
        }*/

    }
}
