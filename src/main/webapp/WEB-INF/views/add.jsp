<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring Form</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
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

    <p><input type="submit" value="Zapisz"/></p>
</form:form>
</body>
</html>
