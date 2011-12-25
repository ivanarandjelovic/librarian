<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Librarian - Create New Book</title>
</head>
<body>
	<h1>Create New Book</h1>

	<form action="/createNewBook" method="POST">
		<table>
			<tr>
				<td>Title</td>
				<td><input id="title" name="title" type="text" size="100">
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input id="createNewBookButton" type="submit" id="create_button" value="Create">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
