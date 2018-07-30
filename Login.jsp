 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#3ea6b9;">
<center > <h1>Your login page</h1></center>
<form action="UserServlet" method="post">
<b><center>Username:<input type="text" id="user"  name="user"/></center><br></b>
<b><center>Password:<input type="password" id="pass" name="pass"></center></b><br>
<center><input type="submit" value="Login" />
</center>
</form>
</body>
</html>