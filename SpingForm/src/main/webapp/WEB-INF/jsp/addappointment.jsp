<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="core" uri="jakarta.tags.core" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Patient Registration</title>
</head>

<body>

    <h1>${mainHeader}</h1>
    <h1>patient appointment registration status</h1>
    <p>${message}</p>

    <table>
        <tr>
            <td>Patient Name:</td>
            <td>${patient.patientName}</td>
        </tr>

        <tr>
            <td>Patient Contact:</td>
            <td>${patient.patientContact}</td>
        </tr>

        <tr>
            <td>Patient Gender:</td>
            <td>${patient.patientGender}</td>
        </tr>

        <tr>
            <td>Patient Date of Birth:</td>
            <td>${patient.patientDoB}</td>
        </tr>

        <tr>
            <td>Patient Allergies:</td>
            <td>
                <c:forEach var="allergy" items="${patient.patientAllergies}">${allergy}<br/></c:forEach>
            </td>
        </tr>

        <tr>
            <td colspan="2">Patient address details:</td>
        </tr>

        <tr>
            <td>Street:</td>
            <td>${patient.patientAddress.street}</td>
        </tr>

        <tr>
            <td>City:</td>
            <td>${patient.patientAddress.city}</td>
        </tr>

        <tr>
            <td>State:</td>
            <td>${patient.patientAddress.state}</td>
        </tr>

        <tr>
            <td>Country:</td>
            <td>${patient.patientAddress.country}</td>
        </tr>

        <tr>
            <td>Pincode:</td>
            <td>${patient.patientAddress.pincode}</td>
        </tr>

<%--        <tr>--%>
<%--            <td>Newsletter subscription:</td>--%>
<%--            <td>${patient.receiveNewsletter}</td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td>Interests:</td>--%>
<%--            <td>--%>
<%--                <core:forEach var="interest" items="${patient.interests}">--%>
<%--                    ${interest}<br/>--%>
<%--                </core:forEach>--%>
<%--            </td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td>favourite:</td>--%>
<%--            <td>${patient.favouriteWord}</td>--%>
<%--        </tr>--%>

    </table>
</body>
</html>
