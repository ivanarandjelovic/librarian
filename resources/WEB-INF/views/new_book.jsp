<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Librarian - Create New Book</title>
<link rel="stylesheet" type="text/css" href="/static/styles.css" />
</head>
<body>
	<h1>Create New Book</h1>

<form:form  commandName="book">
		<table>
			<tr>
				<td>Title</td>
				<td><form:input path="title" size="50"/>
					 <form:errors  path="title" commandName="book" cssClass="formInputError"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input id="createButton" name="createButton" type="submit" id="create_button" value="Create">
				</td>
			</tr>
		</table>
</form:form>
</body>
</html>
