<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contract overview</title>

    <style>
        .table tr:first-child td {
            background: lightgray;
            border: 3px solid lightgray;
        }

        td {
            text-align: center;
        }

        table {
            background: lavender;
        }
    </style>
</head>
<body>
    <h1>Contract overview</h1>

    <h2>purchase contracts:</h2>

    <table class="table" cellspacing="0" cellpadding="0">
        <tr>
            <td>contract ID</td>
            <td>contract number</td>
            <td>contract date</td>
            <td>place</td>
            <td>person ID</td>
            <td>house ID</td>
            <td>number of installments</td>
            <td>intrest rate</td>
        </tr>

        <c:forEach var="purchaseContract" items="${purchaseContracts}">
            <tr>
                <td>${purchaseContract.id}</td>
                <td>${purchaseContract.contractNumber}</td>
                <td>${purchaseContract.date}</td>
                <td>${purchaseContract.place}</td>
                <td>${purchaseContract.personID}</td>
                <td>${purchaseContract.houseID}</td>
                <td>${purchaseContract.noOfInstallments}</td>
                <td>${purchaseContract.intrestRate}</td>
            </tr>
        </c:forEach>
    </table>


    <h2>tenancy contracts:</h2>

    <table class="table" cellspacing="0" cellpadding="0">
        <tr>
            <td>contract ID</td>
            <td>contract number</td>
            <td>contract date</td>
            <td>place</td>
            <td>person ID</td>
            <td>apartment ID</td>
            <td>start date</td>
            <td>duration days</td>
            <td>additional costs</td>
        </tr>

        <c:forEach var="tenancyContract" items="${tenancyContracts}">
            <tr>
                <td>${tenancyContract.id}</td>
                <td>${tenancyContract.contractNumber}</td>
                <td>${tenancyContract.date}</td>
                <td>${tenancyContract.place}</td>
                <td>${tenancyContract.personID}</td>
                <td>${tenancyContract.apartmentID}</td>
                <td>${tenancyContract.startDate}</td>
                <td>${tenancyContract.duration}</td>
                <td>${tenancyContract.additionalCosts}</td>
            </tr>
        </c:forEach>
    </table>


    <br>
    <a href="main">back to menu</a>
</body>
</html>
