<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete apartment</title>
</head>
<body>
<h1>Delete apartment</h1>

<c:url var="deleteUrl" value="/manager/deleteApartment"/>

<form method="POST" action="${deleteUrl}">
    <fieldset style="width: 300px">
        <legend>Delete an existing apartment</legend>

        <br>

        <label>apartment ID: </label> <br>
        <input type="text" name="apartmentId" /> <br> <br>
        <button type="submit">delete apartment</button>

    </fieldset>
</form>

<a href="main">back to menu</a>
</body>
</html>
