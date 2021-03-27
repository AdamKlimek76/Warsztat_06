<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring Form</title>
</head>
<body>
<form method="post" action="/jpa/books/show">
    Pokaż szczegóły wybranej książki:
    <select name="bookId">
        <c:forEach var="book" items="${allBooks}">
            <option value=${book.id}>${book.title}</option>
        </c:forEach>>
    </select>
    <input type="submit" value="Pokaż szczegóły ksiązki"/>
</form>
</body>
</html>
