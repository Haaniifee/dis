<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Login</title>
</head>
<body>
    Login-Password:

    <br><br>


    <c:url var="manageAgents" value="/manager/manage-estate-agents"/>

    <form method="POST" action="${manageAgents}">

        <input type="password" name="loginPassword" />

        <br>
        <br>

        <button type="submit">login</button>
    </form>

    <a href="main">back to menu</a>

</body>
</html>