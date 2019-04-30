<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit estate agent</title>
</head>
<body>
<h1>Edit estate agent</h1>

<c:url var="editUrl" value="/manager/editEstateAgent"/>

<form:form method="POST" action="${editUrl}" modelAttribute="estateAgent">
    <fieldset style="width: 300px">
        <legend>Edit an existing estate agent account</legend>

        <br>

        <form:label path="firstName">first name: </form:label> <br>
        <form:input path="firstName"/> <br> <br>

        <form:label path="lastName">last name: </form:label> <br>
        <form:input path="lastName"/> <br> <br>

        <form:label path="address">address: </form:label> <br>
        <form:input path="address"/> <br> <br>

        <form:label path="loginName">login name: </form:label> <br>
        <form:input path="loginName"/> <br> <br>

        <form:label path="loginPass">login password: </form:label> <br>
        <form:input path="loginPass"/> <br> <br>

        <form:button name="edit account">edit account</form:button>

    </fieldset>
</form:form>

<a href="main">back to menu</a>
</body>
</html>
