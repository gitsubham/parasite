<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" name="viewport"
	content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>Parasite</title>
</head>
<body>

	<%@include file="includes/header.jsp"%>
	<div class="container-fluid">
		<div style="margin: 10%"></div>
		<div class="col-lg-3"></div>
		<div class=" well col-lg-6">

			<form class="well" method="post" action="#">
				<div class="col-lg-9 input-group-lg">
					<h3>Are you sure that you want to verify number ${phoneNumber}
						against ${actualDocId}</h3>
				</div>
				<div class="col-lg-3">
					<button class="btn btn-lg btn-primary" type="submit">Generate
						OTP</button>
				</div>

			</form>



		</div>

	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>

