<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#table_id td.y_n').each(function() {
			if ($(this).text().includes("_INVALID")) {
				$(this).css('background-color', '#ff0000');
			}
			if ($(this).text().includes("_VALID")) {
				$(this).css('background-color', '#008000');
			}
		});
	});
</script>
</head>
<body>
	<div align="center">
		<h1>Employee List</h1>

		<table id="table_id" border="1">

			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Std_Id</th>
			<th>Action</th>

			<c:forEach var="employee" items="${listEmployee}">
				<tr>

					<td class="y_n">${employee.name}</td>
					<td class="y_n">${employee.email}</td>
					<td class="y_n">${employee.address}</td>
					<td class="y_n">${employee.telephone}</td>
					<td class="y_n">${employee.std_id}</td>
					<td><a href="editEmployee?id=${employee.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteEmployee?id=${employee.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>

		<h4>
			New Employee Register <a href="newEmployee">here</a>
		</h4>
	</div>
</body>
</html>