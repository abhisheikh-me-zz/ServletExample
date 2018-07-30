<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   session = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file ="menu.jsp" %>
<link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Customer Details</title>
</head>
<body>
<table id="example" cellspacing="0"  class="display" width="60%">
        <thead>
            <tr>
                <th>cName</th>
                <th>cId</th>
                <th>Address1</th>
                <th>Address2</th>
                <th>Pin</th>
                <th>Email</th>
                <th>Number</th>
                <th>Contact Person</th>
                <th>Record Status</th>
                <th>Flag</th>
                <th>Created Date</th>
                <th>Created By</th>
                <th>Modified Date</th>
                <th>Modified By</th>
                <th>Authorized Date</th>
                 <th>Authorized By</th>
                
            </tr>
        </thead>
        <tfoot>
            <tr>
                  <th>cName</th>
                <th>cId</th>
                <th>Address1</th>
                <th>Address2</th>
                <th>Pin</th>
                <th>Email</th>
                <th>Number</th>
                <th>Contact Person</th>
                <th>Record Status</th>
                <th>Flag</th>
                <th>Created Date</th>
                <th>Created By</th>
                <th>Modified Date</th>
                <th>Modified By</th>
                <th>Authorized Date</th>
                 <th>Authorized By</th>
            </tr>
        </tfoot>
        <tbody>
       
                <c:forEach items="${customer}" var="customer">
			   <tr>
                        <td>${customer.getCustomerCode()}</td>
                	  	 <td>${customer.getCustomerName()}</td>
                	  	 <td>${customer.getCustomerAddress1()}</td>
                	  	 <td>${customer.getCustomerAddress2()}</td>
                	  	 <td>${customer. getCustomerPinCode()}</td>
                	  	 <td>${customer.getEmailaddress()}</td>
                	  	 <td>${customer.getContactNumber()}</td>
                	  	 <td>${customer.getPrimaryContactPerson()}</td>
                	  	 <td>${customer.getRecordStatus()}</td>
                	  	 <td>${customer.getActiveInactiveFlag()}</td>
                	  	 <td>${customer.getCreateDate()}</td>               	  	 
                	  	 <td>${customer.getCreatedBy()}</td>
                	  	 <td>${customer.getModifiedDate()}</td>
                	  	 <td>${customer.getModifiedBy()}</td>
                	  	 <td>${customer.getAuthorizedDate()}</td>
                	  	 <td>${customer.getAuthorizedBy()}</td>
                           
                    </tr>
			</c:forEach>
        </tbody>
        </table>
      

<script src="https://code.jquery.com/jquery-1.12.4.js" type="text/javascript"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script>
$(document).ready(function()
{
    $('#example').DataTable();
} );
</script>
</body>
</html>