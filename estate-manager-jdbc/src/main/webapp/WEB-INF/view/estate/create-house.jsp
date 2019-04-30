<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert house</title>
</head>
<body>
<h1>Insert house</h1>

<c:url var="createUrl" value="/manager/createHouse"/>

<form:form method="POST" action="${createUrl}" modelAttribute="house">
    <fieldset style="width: 300px">
        <legend>Insert a new house</legend>

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

        <form:label path="floors">floors: </form:label> <br>
        <form:input path="floors" /> <br> <br>

        <form:label path="price">price: </form:label> <br>
        <form:input path="price" /> <br> <br>

        <form:label path="garden">garden: </form:label> <br>
        <form:input path="garden" /> <span style="color: lightgray">1 = true, 0 = false</span><br> <br>

        <form:button name="insert house">insert house</form:button>
    </fieldset>
</form:form>

<a href="main">back to menu</a>
</body>
</html>
