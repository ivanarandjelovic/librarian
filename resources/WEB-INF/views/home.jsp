<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Librarian Home Page</title>
</head>
<body>
	<h1>Hello world! I am Librarian!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<p>Books:</p>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td>${book.id}</td>
				<td>${book.title}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
