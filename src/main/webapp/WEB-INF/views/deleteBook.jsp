<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring Form</title>
</head>
<body>
<form method="post" action="/jpa/books/delete">
    Wybierz ksiazkę do usunięcia:
    <select name="bookId">
        <c:forEach var="bookToDelete" items="${allBooks}">
            <option value=${bookToDelete.id}>${bookToDelete.title}</option>
        </c:forEach>>
    </select>
    <input type="submit" value="Usuń wybraną ksiazkę"/>
</form>
</body>
</html>
