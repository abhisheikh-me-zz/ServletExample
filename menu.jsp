<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
        function preventBack() { window.history.forward(); }
        setTimeout("preventBack()", 0);
        window.onunload = function () { null };
    </script>


</head>
<body style="background-color:#ffa500;">
<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="http://localhost:8080/BRD2/CustomerServlet?action=home">Homepage</a>
</div>
<ul class="nav navbar-nav">
<li class="active"><a href="http://localhost:8080/BRD2/CustomerServlet?action=NewCustomer">New Customer</a></li>
<li><a href="http://localhost:8080/BRD2/CustomerServlet?action=update">Update</a></li>
<li><a href="http://localhost:8080/BRD2/CustomerServlet?action=View">View Customer</a></li>
<li><a href="http://localhost:8080/BRD2/CustomerServlet?action=delete">Delete</a></li>
<li><a href="http://localhost:8080/BRD2/CustomerServlet?action=logout">Logout</a></li>
 </ul>
</div>
</nav>
<div class="container">
<center><h3>BRD Completion</h3></center>
</div>
</body>
</html>