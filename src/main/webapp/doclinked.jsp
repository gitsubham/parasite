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
		<div class=" col-lg-7">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="text-align: center">Documents
						Linked</h3>
				</div>
				<table class="table ">
					<tr>
						<td>#</td>
						<td>Document Type</td>
						<td>Document Id</td>
						<td>Action</td>
					</tr>
					<tr>
						<form class="verifyConnection" method="post" action="#">
							<td >1</td>
							<td id="docType">Pan Card</td>
							<td id="actualDocId">ABC</td>
							<td>
								<button class="btn  btn-sm btn-primary" type="submit">View
									Numbers</button>
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

