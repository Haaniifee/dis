<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit apartment</title>
</head>
<body>
<h1>Edit apartment</h1>

<c:url var="editUrl" value="/manager/editApartment"/>
<c:url var="filledEditUrl" value="/manager/showFilledApartmentEditForm"/>


<form method="POST" action="${filledEditUrl}">
    <label>apartment id: </label> <br>
    <input type="text" name="apartmentId">
    <button type="submit">search</button>
    <br> <br>
</form>


<form:form method="POST" action="${editUrl}" modelAttribute="apartment">
    <fieldset style="width: 300px">
        <legend>Edit an existing house</legend> <br>

        <form:label path="city">set new city: </form:label> <br>
        <form:input path="city" disabled="${trigger}"/> <br> <br>

        <form:label path="postalCode">set new postalCode: </form:label> <br>
        <form:input path="postalCode" disabled="${trigger}"/> <br> <br>

        <form:label path="street">set new street: </form:label> <br>
        <form:input path="street" disabled="${trigger}"/> <br> <br>

        <form:label path="number">set new number: </form:label> <br>
        <form:input path="number" disabled="${trigger}"/> <br> <br>

        <form:label path="squareArea">set new squareArea: </form:label> <br>
        <form:input path="squareArea" disabled="${trigger}"/> <br> <br>

        <form:label path="floor">set new floor: </form:label> <br>
        <form:input path="floor" disabled="${trigger}"/> <br> <br>

        <form:label path="rent">set new rent: </form:label> <br>
        <form:input path="rent" disabled="${trigger}"/> <br> <br>

        <form:label path="balcony">set new balcony: </form:label> <br>
        <form:input path="balcony" disabled="${trigger}"/> <br> <br>

        <form:label path="kitchen">set new built in kitchen: </form:label> <br>
        <form:input path="kitchen" disabled="${trigger}"/> <br> <br>

        <form:button name="edit apartment" disabled="${trigger}">edit apartment</form:button>
    </fieldset>
</form:form>

<a href="main">back to menu</a>
</body>
</html>
