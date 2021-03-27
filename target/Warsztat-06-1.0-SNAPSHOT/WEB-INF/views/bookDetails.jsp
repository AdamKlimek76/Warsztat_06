<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <p>Szczegóły ksiązki</p>
</head>
<body>
Isbn:
<p><c:out value="${book.isbn}"/></p>
Tytuł:
<p><c:out value="${book.title}"/></p>
Autor:
<p><c:out value="${book.author}"/></p>
Wydawca:
<p><c:out value="${book.publisher}"/></p>
Typ:
<p><c:out value="${book.type}"/></p>
</body>
</html>
