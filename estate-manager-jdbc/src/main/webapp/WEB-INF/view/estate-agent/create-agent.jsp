<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create estate agent</title>
</head>
<body>
    <h1>Create estate agent</h1>

    <c:url var="createUrl" value="/manager/createEstateAgent"/>

    <form:form method="POST" action="${createUrl}" modelAttribute="estateAgent">
    <fieldset style="width: 300px">
        <legend>Create a new estate agent account</legend>

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

        <form:button name="create">create account</form:button>

    </fieldset>
    </form:form>

    <a href="main">back to menu</a>
</body>
</html>
