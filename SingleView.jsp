<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file ="menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body   style= "background-color:#ff9933;">
<form action="CustomerServlet?action=singleView" method="post">
<center><h1>Enter Customer Code to View:</h1></center>
<b><center>CustomerCode:<input type="text"  name="code"/></center><br></b>
<center><input type="submit" value="Search" ></center>
</form>
</body>
</html>