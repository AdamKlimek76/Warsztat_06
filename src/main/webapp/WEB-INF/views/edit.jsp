<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book add</title>
</head>
<body>
<c:url var="editBookUrl" value="/jpa/books/editbook"/>
<form:form method="post" modelAttribute="editBook" action="${editBookUrl}">
    <form:hidden path="id" />
    <p>isbn: <form:input path="isbn"/></p>
    <form:errors path="isbn" cssClass="error"/>

    <p>title: <form:input path="title"/></p>
    <form:errors path="title" cssClass="error"/>

    <p>author: <form:input path="author"/></p>
    <form:errors path="author" cssClass="error"/>

    <p>publisher: <form:input path="publisher"/></p>
    <form:errors path="publisher" cssClass="error"/>

    <p>type: <form:input path="type"/></p>
    <form:errors path="type" cssClass="error"/>

    <p><input type="submit" value="Zapisz zmiany"/></p>
</form:form>

</body>
</html>

