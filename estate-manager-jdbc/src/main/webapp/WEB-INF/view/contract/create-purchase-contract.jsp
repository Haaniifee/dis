<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make purchase contract</title>
</head>
<body>
<h1>Make purchase contract</h1>

<c:url var="createUrl" value="/manager/createPurchaseContract"/>

<form:form method="POST" action="${createUrl}" modelAttribute="purchaseContract">
    <fieldset style="width: 300px">
        <legend>Make a new purchase contract</legend>

        <br>

        <form:label path="personID">person id: </form:label> <br>
        <form:input path="personID"/> <br> <br>

        <form:label path="houseID">house id: </form:label> <br>
        <form:input path="houseID"/> <br> <br>

        <form:label path="contractNumber">contract number: </form:label> <br>
        <form:input path="contractNumber"/> <br> <br>

        <form:label path="date">date: </form:label><br>
        <form:input path="date"/> <span style="color: lightgray">yyyy-mm-dd</span><br> <br>

        <form:label path="place">place: </form:label> <br>
        <form:input path="place"/> <br> <br>

        <form:label path="noOfInstallments">number of installments: </form:label> <br>
        <form:input path="noOfInstallments"/> <br> <br>

        <form:label path="intrestRate">intrest rate: </form:label> <br>
        <form:input path="intrestRate"/> <br> <br>

        <form:button name="create">make purchase contract</form:button>

    </fieldset>
</form:form>

<a href="main">back to menu</a>
</body>
</html>
