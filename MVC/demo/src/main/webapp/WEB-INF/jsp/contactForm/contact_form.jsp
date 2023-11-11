<%@ page language="java" contentType="text/html charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>Contact Form</head>

    <body>
        <h1>Contact Us</h1>

        <form:form method="POST" modelAttribute="contactForm">
            <table>
                <tr>
                    <td>Name:</td>
                    <td>
                        <form:input path="name"/>
                        <form:errors path="name" cssStyle="color: #ff0000;"/>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <form:input path="email"/>
                        <form:errors path="email" cssStyle="color: #ff0000;"/>
                    </td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td>
                        <form:radiobuttons path="gender" items="${genders}"/>
                        <form:errors path="gender" cssStyle="color: #ff0000;"/>
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>
                        <form:password path="password" showPassword="true"/>
                        <form:errors path="password" cssStyle="color: #ff0000;"/>
                    </td>
                </tr>
                <tr>
                    <td>Confirm Password:</td>
                    <td>
                        <form:password path="confirmPassword" showPassword="true"/>
                        <form:errors path="confirmPassword" cssStyle="color: #ff0000;"/>
                    </td>
                </tr>
                <tr>
                    <td>Desired courses:</td>
                    <td>
                        <div>
                            <form:checkboxes path="courses" items="${availableCourses}"/>
                            <form:errors path="courses" cssStyle="color: #ff0000;"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Select your toutor:</td>
                    <td>
                        <form:select path="tutor">
                            <form:option value="" label="Select a tutor"/>
                            <form:options items="${availableTutours}"/>
                        </form:select>
                        <form:errors path="tutor" cssStyle="color: #ff0000;"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <form:hidden path="hiddenMessage"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" name="submit" value="Submit">
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>