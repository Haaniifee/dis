<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete estate agent</title>
</head>
<body>
<h1>Create estate agent</h1>

<c:url var="deleteUrl" value="/manager/deleteEstateAgent"/>

<form method="POST" action="${deleteUrl}">
    <fieldset style="width: 300px">
        <legend>Delete an existing estate agent account</legend>

        <br>

        <label>login name: </label> <br>
        <input type="text" name="loginName" /> <br> <br>
        <button type="submit">delete account</button>

    </fieldset>
</form>

<a href="main">back to menu</a>
</body>
</html>
