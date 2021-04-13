<%--
  Created by IntelliJ IDEA.
  User: Gc
  Date: 2021/3/22
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<form method="post" action="register"><!-- within doPost() in servlet-->
    <h>New User Registration</h>
 <%--   <table>
        <tr>
            <td>username</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td><b>Gender</b></td>
            <td><input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="female">Female</td>
        </tr>
        <tr>
            <td>Date of Birth</td>
            <td><input type="text" name="birthDate"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Register"/>
            </td>
        </tr>
    </table>--%>
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender: <input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="female">Female<br/>
    <!-- if name is same it make array -->
    Date of Birth :<input type="text" name="birthdate"><br/>
    <input type="submit" value="Register"/>
</form>
<%@include file="footer.jsp"%>

