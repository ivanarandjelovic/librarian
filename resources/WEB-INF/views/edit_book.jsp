<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Librarian - Edit Book</title>
</head>
<body>
	<h1>Edit Book</h1>

	<form action="/editBook" method="POST">
	<input type="hidden" id="id" name="id" value="${book.id}"/>
		<table>
			<tr>
				<td>Title</td>
				<td><input id="title" name="title" type="text" size="100" value="${book.title}"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input id="saveButton" name="saveButton" type="submit" value="Save">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
