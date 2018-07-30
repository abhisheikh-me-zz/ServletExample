<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

	

	function activnessFlagValidation() {
		document.getElementById("mCustomerActivenessFlagId").innerHTML = "";
		var string = document.getElementById("mCustomerActivenessFlag").value;
		if ((string.length == 1)
				&& ((string.toLowerCase().startsWith("a")) || (string
						.toLowerCase().startsWith("i")))) {
			return true;
		} else {
			document.getElementById("mCustomerActivenessFlagId").innerHTML = "Invalid Record Status";
			return false;
		}
	}
	
	function createDateValidation() {
		document.getElementById("mCustomerCreateDateId").innerHTML = "";
		var string = document.getElementById("mCustomerCreateDate").value.toUpperCase();
		
		 if((!(/^([3]{1})([0]{1})-([JFMASOCND]{1})([AEPUCO]{1})([NBRYGLPTVC]{1})-([0-9]{2})$/.test(string)))&&(!(/^([0-2]{1})([0-9]{1})-([jfmasocndJFMASOCND]{1})([AEPUCOaepuco]{1})([nbryglptvcNBRYGLPTVC]{1})-([0-9]{2})$/.test(string)))){
			document.getElementById("mCustomerCreateDateId").innerHTML = "Enter Valid date";
			return false;
		}
		return true;
	}
	
</script>
</head>
<body>
<form action="CustomerServlet?action=ViewByChoice" method="post">
Date:<input type="text" onblur = "createDateValidation();" id = "mCustomerCreateDate"   name="Date"/><p id = "mCustomerCreateDateId"></p>
Active/Inactive Flag:<input type="text" id="Active/InactiveFlag" name="Flag">
<input type="submit" value="Submit" >
</form>
</body>
</html>