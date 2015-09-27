
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="org.nasscom.parasite.beans.Document"%>
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

	<%
		AppUser user = (AppUser) session.getAttribute("user");
		if (user!= null && StringUtils.isNotBlank(user.getMobileNumber())) {

		ArrayList<Document> documents = user.getDocumentList();
		if (documents.isEmpty()) {
			out.println("<tr><td colspan=\"4\">No record found. </td></tr>");
		} else {
			int count = 1;
			for (Document doc : documents) {
			%>
			<tr>
				<form class="viewLinkedNumbers" method="post" action="./details">
				<td ><% out.print(count); %></td>
				<td><input type="text" id="docType" name="docType" value="<% out.print(doc.getDocType()); %>" readonly /></td>
				<input type="hidden" id="actualDocId" name="actualDocId" val="<% out.print(doc.getActualDocId()); %>" />
				<td> <% out.print(doc.getEncryptedDocId());%> </td>
				<td><button class="btn  btn-sm btn-primary" type="submit">View Numbers</button></td>
				</form>
			</tr>
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

				</table>
			</div>
		</div>
	</div>
	

	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>

