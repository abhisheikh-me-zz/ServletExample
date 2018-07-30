<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
        function preventBack() { window.history.forward(); }
        setTimeout("preventBack()", 0);
        window.onunload = function () { null };
    </script>
<title>Insert title here</title>
</head>
<body style= "background-color:#3ea6b9;">
<form action="Login.jsp">
<center><h1>OOPS Wrong Credentials:&#9786;</h1></center>
<center><input type="submit" value="Login again" ></center>
</form>
</body>
</html>