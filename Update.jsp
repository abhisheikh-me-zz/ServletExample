<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">

	function validation() {
	   
		var passa = nameValidation();
		var passb = address1Validation();
		var passc = pinCodeValidation();
		var passd = emailValidation();
		var passe = contactNumberValidation();
		var passf = recordStatusValidation();
		var passg = activnessFlagValidation();
		var passh = contactPersonValidation();
		var passi = createDateValidation();
		var passj = createByValidation();
		if ( passa && passb && passc && passd && passe && passf && passg && passh && passi && passj) {
		
		    document.getElementById("mFormId").submit();
			return true;
		} else{
		    alert("Please fill in the details");
			return false;
		}
	}
	function nameValidation() {
		
		document.getElementById("mCustomerNameId").innerHTML = "";
		var string = document.getElementById("mCustomerName").value;
		if ((string.length < 30) && (string.length > 0)
				&& (/^[A-Za-z ]+$/.test(string))) {
			return true;
		} else {
			document.getElementById("mCustomerNameId").innerHTML = "Invalid User Name";
			return false;
		}
	}

	function address1Validation() {
		document.getElementById("mCustmerAddress1Id").innerHTML = "";
		var string = document.getElementById("mCustomerAddress1").value;
		if (!string.length > 0) {
			document.getElementById("mCustmerAddress1Id").innerHTML = "Invalid Address";
			return false;
		}
		return true;

	}

	function pinCodeValidation() {
		document.getElementById("mCustomerPincodeId").innerHTML = "";
		var string = document.getElementById("mCustomerPincode").value;
		if ((isNaN(string) || (string.length != 6))) {
			document.getElementById("mCustomerPincodeId").innerHTML = "Invalid Pincode";
			return false;
		}
		return true;

	}

	function emailValidation() {
		document.getElementById("mCustomerEmailAddressId").innerHTML = "";
		var atTheRate = 0, dot = 0, i;
		var continueEntry = false;
		var string = document.getElementById("mCustomerEmailAddress").value;
		for (i = 0; i < string.length; i++) {
			if ((string.charAt(i) == '@') || (continueEntry)) {
				continueEntry = true;
				if (string.charAt(i) == '.')
					dot++;
				if (string.charAt(i) == '@')
					atTheRate++;
			}
		}
		if ((atTheRate > 1) || string.startsWith("@") || string.includes("@.")
				|| string.endsWith(".") || (dot != 1)) {

			document.getElementById("mCustomerEmailAddressId").innerHTML = "Invalid Email";
			return false;
		}
		return true;
	}
	function contactNumberValidation() {
		document.getElementById("mCustomerContactNumberId").innerHTML = "";
		var string = document.getElementById("mCustomerContactNumber").value;
		if ((isNaN(string) || (string.length != 10))) {
			document.getElementById("mCustomerContactNumberId").innerHTML = "Invalid PhoneNumber";
			return false;
		}
		return true;
	}

	function recordStatusValidation() {
		document.getElementById("mCustomerRecordStatusId").innerHTML = "";
		var string = document.getElementById("mCustomerRecordStatus").value;
		if ((string.length == 1)
				&& ((string.toLowerCase().startsWith("n"))
						|| (string.toLowerCase().startsWith("m"))
						|| (string.toLowerCase().startsWith("d"))
						|| (string.toLowerCase().startsWith("a")) || (string
						.toLowerCase().startsWith("r")))) {
			return true;
		} else {
			document.getElementById("mCustomerRecordStatusId").innerHTML = "Invalid Record Status";
			return false;
		}
	}
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
	function contactPersonValidation() {
		document.getElementById("mCustomerContactPersonId").innerHTML = "";
		var string = document.getElementById("mCustomerContactPerson").value;
		if (!string.length > 0) {
			document.getElementById("mCustomerContactPersonId").innerHTML = "Invalid Contact Person";
			return false;
		}
		return true;
	}
	function createDateValidation() {
		document.getElementById("mCustomerCreateDateId").innerHTML = "";
		var string = document.getElementById("mCustomerCreateDate").value.toUpperCase();
		
		 if((!(/^([3]{1})([0]{1})-([JFMASOCND]{1})([AEPUCO]{1})([NBRYGLPTVC]{1})-([0-9]{2})$/.test(string)))&&(!(/^([0-2]{1})([0-9]{1})-([jfmasocndJFMASOCND]{1})([AEPUCOaepuco]{1})([nbryglptvcNBRYGLPTVC]{1})-([0-9]{2})$/.test(string)))){
			document.getElementById("mCustomerCreateDateId").innerHTML = "Invalid Date Format eg: 19-jul-18";
			return false;
		}
		return true;
	}
	function createByValidation() {
		document.getElementById("mCustomerCreateById").innerHTML = "";
		var string = document.getElementById("mCustomerCreateBy").value;
		if (!string.length > 0) {
			document.getElementById("mCustomerCreateById").innerHTML = "Invalid Create By";
			return false;
		}
		return true;
	}
	function authorizedDateValidation(){
	document.getElementById("mCustomerAuthorizedDateId").innerHTML = "";
		var string = document.getElementById("mCustomerAuthorizedDate").value.toUpperCase();
		if(string.length>0){
		if((!(/^([3]{1})([0]{1})-([JFMASOCND]{1})([AEPUCO]{1})([NBRYGLPTVC]{1})-([0-9]{2})$/.test(string)))&&(!(/^([0-2]{1})([0-9]{1})-([jfmasocndJFMASOCND]{1})([AEPUCOaepuco]{1})([nbryglptvcNBRYGLPTVC]{1})-([0-9]{2})$/.test(string)))){
			document.getElementById("mCustomerAuthorizedDateId").innerHTML = "Invalid Date Format eg: 19-jul-18";
			return false;
		}
		}
		 
		return true;
	}
	function modifiedDateValidation(){
	document.getElementById("mCustomerModifiedDateId").innerHTML = "";
		var string = document.getElementById("mCustomerModifiedDate").value.toUpperCase();
		if(string.length>0){
		if((!(/^([3]{1})([0]{1})-([JFMASOCND]{1})([AEPUCO]{1})([NBRYGLPTVC]{1})-([0-9]{2})$/.test(string)))&&(!(/^([0-2]{1})([0-9]{1})-([jfmasocndJFMASOCND]{1})([AEPUCOaepuco]{1})([nbryglptvcNBRYGLPTVC]{1})-([0-9]{2})$/.test(string)))){
			document.getElementById("mCustomerModifiedDateId").innerHTML = "Invalid Date Format eg: 19-jul-18";
			return false;
		}
		}
		 
		return true;
	}
</script>
<%@ include file ="menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style= "background-color:#ff9933;">
<center><h1> Update Customer</h1></center>
<form action="CustomerServlet?action=updateDetail" method="post">
<table>
<c:forEach items="${customer}" var="customer">
<tr>
<td><b>CustomerCode:</td><td><input  type="text"  name="code" value="${customer.getCustomerCode()}"/><br></b><p></td>
</tr>
<tr>
<td><b>CustomerName:</td><td><input  onblur ="nameValidation();"  type="text" id="mCustomerName"  name="name" value="${customer.getCustomerName()}"/><br><p id ="mCustomerNameId"></b>
</td>
</tr>
<tr>
<td><b>CustomerAddress1:</td><td><input  onblur = "address1Validation();" type="text" id="mCustomerAddress1" name="Address1" value="${customer.getCustomerAddress1()}"/><br></b><p id="mCustmerAddress1Id"></td>
</tr>
<tr>
<td><b>CustomerAddress2:</td><td><input  onblur = "address1Validation();" type="text" id="mCustomerAddress1"  name="Address2" value="${customer.getCustomerAddress2()}"/><br></b><p id="mCustmerAddress1Id"></td>
</tr>
<tr>
<td><b>CustomerPincode:</td><td><input  onblur="pinCodeValidation();"  type="text" id="mCustomerPincode"  name="Pincode" value="${customer. getCustomerPinCode()}"/><br></b><p id ="mCustomerPincodeId"></td>
</tr>
<tr>
<td><b>E_mailAddress :</td><td><input  onblur="emailValidation();"  id="mCustomerEmailAddress"   type="text"  name="E_mailAddress" value="${customer.getEmailaddress()}"/><br></b><p id="mCustomerEmailAddressId"></td>
</tr>
<tr>
<td><b>Contact number:</td><td><input  onblur="contactNumberValidation();"  type="text" id="mCustomerContactNumber"  name="Contactnumber" value="${customer.getContactNumber()}"/><br></b><p id="mCustomerContactNumberId"></td>
</tr>
<tr>
<td><b>PrimaryContactPerson  :</td><td><input  onblur="contactPersonValidation();" type="text" id="mCustomerContactPerson" name="PrimaryContactPerson" value="${customer.getPrimaryContactPerson()}"/><br></b><p id="mCustomerContactPersonId"></td>
</tr>
</c:forEach>
</table>
<input type="submit" value="Submit" />
</form>
</body>
</html>