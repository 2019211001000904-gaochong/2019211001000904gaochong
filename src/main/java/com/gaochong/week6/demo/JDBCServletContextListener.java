package com.gaochong.week6.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    Connection con = null;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //this method is like main() for this web app
        //when this method called - tomcat start
        ServletContext Context = sce.getServletContext();
        System.out.println("i m in contextInitialized()");
        String driver = Context.getInitParameter("driver");
        String url = Context.getInitParameter("url");
        String username = Context.getInitParameter("username");
        String password = Context.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            Context.setAttribute("con",con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
        @Override
        public void contextDestroyed (ServletContextEvent sce){
            //this method is like end point web app
            //when this method called -- tomcat stop
            System.out.println("i m in contextDestroyed()");
            try {
                con.close();
                sce.getServletContext().removeAttribute("con");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
