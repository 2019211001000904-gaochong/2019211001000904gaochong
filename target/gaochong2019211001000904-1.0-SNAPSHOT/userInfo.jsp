<%--
  Created by IntelliJ IDEA.
  User: Gc
  Date: 2021/4/10
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    //read cookies
    Cookie[] allCookie=request.getCookies();//all cookies in array
    for (Cookie c:allCookie){
        //get one by one
        out.println("<br/>"+c.getName()+" == "+c.getValue());
    }
%>
<table>

    <tr><td>Username:</td><td><%=request.getAttribute("username")%></td></tr>
    <tr> <td>Password:</td><td><%=request.getAttribute("password")%></td></tr>
    <tr> <td>Email:</td><td><%=request.getAttribute("email")%></td></tr>
    <tr> <td>Gender:</td><td><%=request.getAttribute("gender")%></td></tr>
    <tr>  <td>Birth Date:</td><td><%=request.getAttribute("birthdate")%></td></tr>

</table>
<%@include file="footer.jsp"%>
