<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="org.nasscom.parasite.base.AppUser"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" name="viewport"
	content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>Parasite | Login</title>
</head>
<body>

	<%@include file="includes/headerLandingPage.jsp"%>
	<div class="container-fluid">
		<div style="margin: 10%"></div>
		<div class="col-lg-3"></div>
		<div class=" well col-lg-6">

			<form class="generate-otp" action="./generate" method="post">

				<div class="col-lg-9 input-group-lg">


	<%
		AppUser user = (AppUser) session.getAttribute("user");

		if (user!= null && StringUtils.isNotBlank(user.getMobileNumber())) {
	%>
					<input id="inputPhone" name="inputPhone" class="form-control "
						placeholder="Phone Number" required="" autofocus="" type="text"
						value="<% out.print(user.getMobileNumber()); %>">
	<%
		}else{
	%>
					<input id="inputPhone" name="inputPhone" class="form-control "
						placeholder="Phone Number" required="" autofocus="" type="text">
	<%
		}
	%>

				</div>
				<div class="col-lg-3">
					<button class="btn btn-lg btn-primary" type="submit">Generate
						OTP</button>
				</div>
			</form>

			<form id="search-number" action="./search" method="post">
				<div class="col-lg-6 input-group-lg">
					<input id="inputOTP" name="inputOTP" class="form-control " placeholder="OTP"
						required="" autofocus="" type="text">
				</div>
				<div style="margin: 10%"></div>

				<div class="col-lg-1">
					<button class="btn btn-lg btn-primary" type="submit">Search</button>
				</div>
			</form>

		</div>

	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>

