<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file ="menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style= "background-color:#3ea6b9;">
<form action="CustomerServlet?action=singleView" method="post">
</form>>
<center><h1>Select Your Choice to view Customer:&#9786;</h1></center>
<form action="SingleView.jsp" method="post">
<center><input type="submit" value="Single View" ></center><br>
</form>
<form action="CustomerServlet?action=viewAll" method="post">
<center><input type="submit" value="Multiple View" ></center><br>
</form>
<form action="ViewChoice.jsp" method="post">
<center><input type="submit" value="view choice" ></center><br>
</form>
</body>
</html>