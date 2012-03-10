<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Librarian - Delete Book</title>
<link rel="stylesheet" type="text/css" href="/static/styles.css" />
</head>
<body>
	<h1>Delete Book</h1>

<form:form  commandName="book">
	<form:hidden path="id"/>
		<table>
			<tr>
				<td>Title</td>
				<td>${book.title}</td>
			</tr>
			<tr>
				<td></td>
				<td>Are you sure? <input id="deleteButton" name="deleteButton" type="submit" value="Delete"/>
				</td>
			</tr>
		</table>
</form:form>
</body>
</html>
