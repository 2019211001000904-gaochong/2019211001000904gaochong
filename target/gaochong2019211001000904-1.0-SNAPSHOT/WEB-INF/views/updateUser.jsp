<%--
  Created by IntelliJ IDEA.
  User: Gc
  Date: 2021/4/25
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>
<!--need form -->
<%
    //get user from session
    User u1=(User) session.getAttribute("user");
%>
<form method="post" action="updateUser"><!-- within doPost() in servlet-->
    <input type="hidden" name="id" value="<%=u1.getId()%>">
    username<input type="text" name="username" value="<%=u1.getUsername()%>"/><br/>
    password<input type="password" name="password" value="<%=u1.getPassword()%>"/><br/>
    Email<input type="text" name="email" value="<%=u1.getEmail()%>"/><br/>
    Gender: <input type="radio" name="gender" value="male" <%="male".equals(u1.getGender())?"checked" :""%>>Male
    <input type="radio" name="gender" value="female" <%="female".equals(u1.getGender())?"checked" :""%>>Female<br/>
    <!-- if name is same it make array -->
    Date of Birth :<input type="text" name="birthdate" value="<%=u1.getBirthdate()%>"><br/>
    <input type="submit" value="Save Changes"/>
</form>
<%@include file="footer.jsp"%>
