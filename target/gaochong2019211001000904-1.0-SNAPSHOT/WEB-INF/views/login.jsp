<%--
  Created by IntelliJ IDEA.
  User: Gc
  Date: 2021/4/5
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
    <h1>
    Login
    </h1>
    <%
        if((request.getAttribute("message")!=null)){
            //error
            out.println(request.getAttribute("message"));
        }
    %>
<%
    //read cookies
    Cookie[]allCookies=request.getCookies();
    String username="",password="",rememberMeVale="";
    if(allCookies!=null){
        //we read 3 cookies
        for (Cookie c:allCookies){
            //get one by one
            if(c.getName().equals("cUsername")){
                //get valuse of this cookies
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                //get valuse of this cookies
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                //get valuse of this cookies
                rememberMeVale=c.getValue();
            }

        }
    }
%>
<form method="post" action="login">
    username<input type="text" name="username" value="<%=username%>"><br/>
    password<input type="password" name="password" value="<%=password%>"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVale.equals("1")?"checked":""%>checked/>Remember Me<br/>
    <input type="submit" value="Login"><br/>
</form>
<%@include file="footer.jsp"%>
