<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make tenancy contract</title>
</head>
<body>
<h1>Make tenancy contract</h1>

<c:url var="createUrl" value="/manager/createTenancyContract"/>

<form:form method="POST" action="${createUrl}" modelAttribute="tenancyContract">
    <fieldset style="width: 300px">
        <legend>Make a new purchase contract</legend>

        <br>

        <form:label path="personID">person id: </form:label> <br>
        <form:input path="personID"/> <br> <br>

        <form:label path="apartmentID">apartment id: </form:label> <br>
        <form:input path="apartmentID"/> <br> <br>

        <form:label path="contractNumber">contract number: </form:label> <br>
        <form:input path="contractNumber"/> <br> <br>

        <form:label path="date">date: </form:label><br>
        <form:input path="date"/> <span style="color: lightgray">yyyy-mm-dd</span><br> <br>

        <form:label path="place">place: </form:label> <br>
        <form:input path="place"/> <br> <br>

        <form:label path="startDate">start date: </form:label> <br>
        <form:input path="startDate"/> <span style="color: lightgray">yyyy-mm-dd</span><br> <br>

        <form:label path="duration">duration days: </form:label> <br>
        <form:input path="duration"/> <br> <br>

        <form:label path="additionalCosts">additional costs: </form:label> <br>
        <form:input path="additionalCosts"/> <br> <br>

        <form:button name="create">make tenancy contract</form:button>

    </fieldset>
</form:form>

<a href="main">back to menu</a>
</body>
</html>