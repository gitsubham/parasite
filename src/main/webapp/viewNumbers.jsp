<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="org.nasscom.parasite.beans.MobileNumber"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.nasscom.parasite.base.AppUser"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" name="viewport"
	content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>Parasite | Assciated Numbers</title>

<script>
function verify(id){
	id.innerHTML="oops !"
	$('#myModal').modal('show'); 
}

</script>

</head>
<body>
	<%@include file="includes/header.jsp"%>
	<div class="container-fluid">
		<div style="margin: 10%"></div>
		<div class="col-lg-3"></div>
		<div class=" col-lg-7">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="text-align: center">Numbers linked with  ${docType} - ${actualDocId}</h3> 
				</div>
				<table class="table ">
					<tr>
						<td>#</td>
						<td></td>
						<td>Mobile Number</td>
						<!-- <td>Telecom Provider</td>  -->
						<td>Action</td>
					</tr>


	<%
		AppUser user = (AppUser) session.getAttribute("user");
		if (user!= null && StringUtils.isNotBlank(user.getMobileNumber())) {

		ArrayList<MobileNumber> numbers = user.getAltMobileList();
		if (numbers.isEmpty()) {
			out.println("<tr><td colspan=\"4\">No record found. </td></tr>");
		} else {
			int count = 1;
			for (MobileNumber num : numbers) {
				out.println("<tr><td>" + count + "</td><td>"
						+ num.getEncryMobNumber() + "</td><td>"
						+ num.getActualmobNumber());
				%>
				</td><td><button class="btn  btn-sm btn-primary" onclick="verify(this)" type="submit">Verify Ownership</button></td></tr>
				<% 
				count++;
			}
		}
		}else{
			// redirect to login page
		%>
			<jsp:forward page="./index.jsp" />
		<%
			
		}
	%>



	<tr>
						<form class="verifyMobileNumber" method="post" action="#">
							<td >1</td>
							<td>
							<input name="actualMobileNumber" type="hidden" value= ${actualMobileNumber}/></td>
							<td id="encryMobNumber" name="encryMobileNumber" type="hidden"/>xxxxx76114</td>
							<!-- <td id="telecomProvider" name="telecomProvider">${telecomProvider}</td>  -->
							<td>
								<button class="btn  btn-sm btn-primary" onclick="verify(this)" type="submit">Verify Ownership</button>
							</td>
						</form>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>

