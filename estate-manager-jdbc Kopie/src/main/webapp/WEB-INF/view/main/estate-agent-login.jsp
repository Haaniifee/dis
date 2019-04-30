<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Estate agent Login</title>
</head>
<body>

    <h1>Estate agent login</h1>

    <c:url var="manageAgents" value="/manager/manage-estates"/>

    <form method="POST" action="${manageAgents}">

        <label>login name</label> <br>
        <input type="text" name="loginName" />

        <br><br>

        <label>login password</label> <br>
        <input type="password" name="loginPassword" />

        <br><br>

        <button type="submit">login</button>
    </form>

    <a href="main">back to menu</a>

</body>
</html>