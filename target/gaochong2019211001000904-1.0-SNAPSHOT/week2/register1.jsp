<%--
  Created by IntelliJ IDEA.
  User: Gc
  Date: 2021/3/14
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form>
<font color="gray">New User Registration!<font><br/><br/>

    <INPUT TYPE="TEXT" size="30" VALUE="Username" onfocus="if(value=='Username'){value=''}"
           onblur="if(value==''){value='Username'}"style="color: gray;background: antiquewhite"><br/><br/>
        <INPUT TYPE="password" size="30" minlength="8" placeholder="password" style="color: gray;background: antiquewhite"/><br/><br/>
    <input type="email" size="30" name="email"  placeholder="Email"style="color: gray;background: antiquewhite" /><br/>
    <label><b><font color="black">Gender</font></b></label>
    <input type="radio" name="sex" value="Male" checked/><font color="black">Male</font>
    <input type="radio" name="sex" value="Female" checked/><font color="black">Female</font><br/>
    <input type="date" size="30" name="Date" placeholder="Date of Birth(yyyy-mm-dd)"style="background: antiquewhite"/><br/><br/>
    <input type="submit" value="Register" style="background: chocolate;text-align: left"/><br/>
</form>
</body>
</html>
