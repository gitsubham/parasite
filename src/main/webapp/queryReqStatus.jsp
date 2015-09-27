
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="org.nasscom.parasite.beans.VfcationRequestForm"%>
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
<link href="css/site-specific-css1.css" rel="stylesheet" media="screen">

<title>Parasite | Document</title>
</head>
<body>
	<%@include file="includes/header.jsp"%>
	<div class="container-fluid">
		<div style="margin: 10%"></div>
		<div class="col-lg-3"></div>
		<div class=" col-lg-7">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="text-align: center">Requests</h3>
				</div>
				<table class="table ">
					<tr>
						<td>#</td>
						<td>Mobile Number</td>
						<td>Request Id</td>
						<td>Request Status</td>
					</tr>

					<%
						AppUser user = (AppUser) session.getAttribute("user");
						if (user != null) {
							int count = 1;
							ArrayList<VfcationRequestForm> reqList = user.getVerifyReqList();
							if (reqList.isEmpty()) {
								out.println("<tr><td></td><td></td><td  colspan=\"4\"><b>No record found.</b> </td></tr>");
							} else {
								for (VfcationRequestForm req : reqList) {
									out.println("<tr>");
									out.println("<td>" + req.getAgstNumber() + "</td>");
									out.println("<td>" + req.getReferenceNum() + "</td>");
									out.println("<td>" + req.getReqStatus() + "</td>");
									out.println("</tr>");
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

