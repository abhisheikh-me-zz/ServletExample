<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file = "menu.jsp" %>
<title>Insert title here</title>
</head>
<body style= "background-color:#ff9933;">
<center><h1>Enter Customer Code to delete:</h1></center>
<form action="CustomerServlet?action=delete" method="post">
<b><center>CustomerCode:<input type="text"  name="code"/></center><br></b>
<center><input type="submit" value="delete" ></center>
</form>
</body>
</html>