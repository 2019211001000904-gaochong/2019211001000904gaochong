<%@include file="header.jsp"%>
<h2>Welcom to My Online Shop Home Page.</h2><br>
<form method="get" target="_blank" action="search">
    <!-- <url-pattern>/search</url-pattern> -->
    <input type="text" name="txt" size="30"/>
    <select name="search">
        <option name="baidu">Baidu</option>
        <option name="bing">Bing</option>
        <option name="google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>
<%@include file="footer.jsp"%>
