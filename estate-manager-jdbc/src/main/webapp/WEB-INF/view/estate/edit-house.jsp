<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit house</title>
</head>
<body>
<h1>Edit house</h1>

<c:url var="editUrl" value="/manager/editHouse"/>
<c:url var="filledEditUrl" value="/manager/showFilledHouseEditForm"/>


<form method="POST" action="${filledEditUrl}">
    <label>house id: </label> <br>
    <input type="text" name="houseId">
    <button type="submit">search</button>
    <br> <br>
</form>


<form:form method="POST" action="${editUrl}" modelAttribute="house">
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

        <form:label path="floors">set new floors: </form:label> <br>
        <form:input path="floors" disabled="${trigger}"/> <br> <br>

        <form:label path="price">set new price: </form:label> <br>
        <form:input path="price" disabled="${trigger}"/> <br> <br>

        <form:label path="garden">set new garden: </form:label> <br>
        <form:input path="garden" disabled="${trigger}"/> <br> <br>

        <form:button name="edit house" disabled="${trigger}">edit house</form:button>

    </fieldset>
</form:form>

<a href="main">back to menu</a>
</body>
</html>
