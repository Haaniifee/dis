<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert apartment</title>
</head>
<body>
<h1>Insert apartment</h1>

<c:url var="createUrl" value="/manager/createApartment"/>

<form:form method="POST" action="${createUrl}" modelAttribute="apartment">
    <fieldset style="width: 300px">
        <legend>Insert a new apartment</legend>

        <br>

        <form:label path="city">city: </form:label> <br>
        <form:input path="city" /> <br> <br>

        <form:label path="postalCode">postalCode: </form:label> <br>
        <form:input path="postalCode" /> <br> <br>

        <form:label path="street">street: </form:label> <br>
        <form:input path="street" /> <br> <br>

        <form:label path="number">number: </form:label> <br>
        <form:input path="number" /> <br> <br>

        <form:label path="squareArea">squareArea: </form:label> <br>
        <form:input path="squareArea" /> <br> <br>

        <form:label path="floor">floor: </form:label> <br>
        <form:input path="floor" /> <br> <br>

        <form:label path="rent">rent: </form:label> <br>
        <form:input path="rent" /> <br> <br>

        <form:label path="balcony">balcony: </form:label> <br>
        <form:input path="balcony" /> <span style="color: lightgray">1 = true, 0 = false</span><br> <br>

        <form:label path="kitchen">built in kitchen: </form:label> <br>
        <form:input path="kitchen" /> <span style="color: lightgray">1 = true, 0 = false</span><br> <br>

        <form:button name="insert apartment">insert apartment</form:button>
    </fieldset>
</form:form>

<a href="main">back to menu</a>
</body>
</html>
