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

<script type="text/javascript">
	function clicked() {
		if (confirm('Do you wanna to submit?')) {
			verifyOwnership.submit();
		} else {
			return false;
		}
	}
</script>

</head>
<body>
	<%@include file="includes/header.jsp"%>
	<div class="container-fluid">
	
	
		<div style="margin: 10%"></div>
		<div class="col-lg-3"></div>
		<div class=" col-lg-7">
		<div >
		<%
			out.println("error --" + session.getAttribute("error"));
			if (session.getAttribute("error") !=null)
				String errorMsg=session.getAttribute("error");
				out.println("<p class=\"bg-danger\">" + errorMsg + "</p>");
			else 
				String successMsg=session.getAttribute("error");
				out.println("<p class=\"bg-success\">" + successMsg + "</p>");
		%>	
		</div>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="text-align: center">Linked Numbers</h3>
				</div>
				<table class="table ">
					<tr>
						<td>#</td>
						<td>Mobile Number</td>
						<td>Associated Document</td> 
						<td>Action</td>
					</tr>


					<%
						AppUser user = (AppUser) session.getAttribute("user");
						if (user != null && StringUtils.isNotBlank(user.getMobileNumber())) {

							ArrayList<MobileNumber> numbers = user.getAltMobileList();
							if (numbers.isEmpty()) {
								out.println("<tr> <td colspan=\"4\">No record found. </td> </tr>");
							} else {
								int count = 1;
								for (MobileNumber num : numbers) {
									out.println("<tr>");
									out.println("<form action=\"./verify\" method=\"post\">");
									out.println("<td>" + count + "</td>");
									out.println("<td>" + num.getEncryMobNumber() + "</td>");
									out.println("<td>" + num.getAssociatedDoc() + "</td>");
									out.print("<td><button id=\"verifyOwnership\" class=\"btn  btn-sm btn-primary\" onclick=\"clicked(this)\" type=\"submit\">Verify Ownership</button></td>");
									out.print("<td><input name=\"actualMobNumber\" type=\"hidden\" val=" +num.getActualmobNumber() + "></td>");
									out.print("<td><input name= \"associatedDoc\" type=\"hidden\" val=" +num.getAssociatedDoc() + "> </td>");
									out.println("</form>");
									out.println("</tr>");				
					%>
					
					<%
						count++;
								}
							}
						} else {
							// redirect to login page
					%>
					<jsp:forward page="./index.jsp" />
					<%
						}
					%>
				</table>
			</div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>

