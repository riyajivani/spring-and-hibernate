<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Patient Registration</title>
</head>
<body>
    <h1>${mainHeader}</h1>
    <h1>patient appointment registration</h1>

    <form:form method="post" action="addappointment" modelAttribute="patient">

        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="patientName" type="text"/></td>
            </tr>

            <tr>
                <td>Contact No:</td>
                <td><form:input path="patientContact" type="text"/></td>
            </tr>

            <tr>
                <td>Gender:</td>
                <td><form:radiobutton path="patientGender" value="Male" label="Male"/></td>
                <td><form:radiobutton path="patientGender" value="Female" label="Female"/></td>
            </tr>

            <tr>
                <td>Date of Birth:</td>
                <td><form:input path="patientDoB" type="date"/></td>
            </tr>

            <tr>
                <td>Allergies:</td>
                <td><form:checkboxes path="patientAllergies" items="${allergyList}"/></td>
            </tr>

            <tr>
                <td colspan="2">Address Details:</td>
            </tr>

            <tr>
                <td>Street:</td>
                <td><form:input path="patientAddress.street" type="text"/></td>
            </tr>

            <tr>
                <td>City:</td>
                <td><form:input path="patientAddress.city" type="text"/></td>
            </tr>

            <tr>
                <td>State:</td>
                <td><form:input path="patientAddress.state" type="text"/></td>
            </tr>

            <tr>
                <td>Country:</td>
                <td><form:select path="patientAddress.country">
                    <form:options items="${countryList}"/>
                </form:select></td>
            </tr>

            <tr>
                <td>Pincode:</td>
                <td>
                    <form:input path="patientAddress.pincode" type="number"/>
                </td>
            </tr>
<%--            <tr>--%>
<%--                <td>subscription to newsletter?:</td>--%>
<%--                <td><form:checkbox path="receiveNewsletter"/></td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td>Interests:</td>--%>
<%--                <td>Food:<form:checkbox path="interests" value="food"/>--%>
<%--                    Smartphone:<form:checkbox path="interests" value="smartphone"/>--%>
<%--                    Movies:<form:checkbox path="interests" value="movies"/></td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td>favorite word:</td>--%>
<%--                <td> myself:<form:checkbox path="favouriteWord" value="myself"/></td>--%>
<%--            </tr>--%>

            <tr>
                <td colspan="2"><input type="submit" value="add my appointment!"/></td>
            </tr>

        </table>

    </form:form>
</body>
</html>
