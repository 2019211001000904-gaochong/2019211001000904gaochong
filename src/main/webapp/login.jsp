<%--
  Created by IntelliJ IDEA.
  User: Gc
  Date: 2021/4/5
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<form method="post" action="login">
<p>
    <b>
    Login
    </b>
    <%
        if(request.getAttribute("message")!=null){
            //error
            out.println(request.getAttribute("message"));
        }
    %>
</p>
    username<input type="text" name="username"><br/>
    password<input type="password" name="password"><br/>
    <input type="submit" value="Login"><br/>
</form>
<%@include file="footer.jsp"%>
