<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert person</title>
</head>
<body>
<h1>Insert person</h1>

<c:url var="createUrl" value="/manager/insertPerson"/>

<form:form method="POST" action="${createUrl}" modelAttribute="person">
    <fieldset style="width: 300px">
        <legend>Insert a new Person</legend>

        <br>

        <form:label path="firstName">first name: </form:label> <br>
        <form:input path="firstName"/> <br> <br>

        <form:label path="lastName">last name: </form:label> <br>
        <form:input path="lastName"/> <br> <br>

        <form:label path="address">address: </form:label> <br>
        <form:input path="address"/> <br> <br>

        <form:button name="create">insert person</form:button>

    </fieldset>
</form:form>

<a href="main">back to menu</a>
</body>
</html>
