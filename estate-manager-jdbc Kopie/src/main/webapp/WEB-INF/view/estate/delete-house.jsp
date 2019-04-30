<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete house</title>
</head>
<body>
<h1>Delete house</h1>

<c:url var="deleteUrl" value="/manager/deleteHouse"/>

<form method="POST" action="${deleteUrl}">
    <fieldset style="width: 300px">
        <legend>Delete an existing house</legend>

        <br>

        <label>house ID: </label> <br>
        <input type="text" name="houseId" /> <br> <br>
        <button type="submit">delete house</button>

    </fieldset>
</form>

<a href="main">back to menu</a>
</body>
</html>
