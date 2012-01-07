<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Librarian Home Page</title>
</head>
<body>
	<h1>Hello world! I am Librarian!</h1>

	<p>
		<a id="openNewBook" href="/openNewBook">Create New Book</a>
		
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
				<td><a id="editBookLink_${book.id}" href="/editBook?id=${book.id}">${book.title}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
