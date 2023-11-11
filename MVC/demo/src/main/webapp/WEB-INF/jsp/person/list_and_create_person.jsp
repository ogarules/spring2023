<%@ page language="java" contentType="text/html charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>Hola spring form</head>
    <body>
        <style>
            .error{
                color: red;
            }
        </style>
        <h1>Persons</h1>
        <h2>Register</h2>

        <form:form action="${pageContext.request.contextPath}/person/create"
                   modelAttribute="personForm"
                   method="POST">
            <table>
                <tr>
                    <td>Nombre:</td>
                    <td>
                        <form:input path="name"/>
                        <form:errors path="name" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>Edad:</td>
                    <td>
                        <form:input path="age"/>
                        <form:errors path="age" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="submit" value="Submit"/>
                    </td>
                </tr>
            </table>

        </form:form>

        <br>
        <hr>
        <br>
        <h2>Personas registradas</h2>
        <c:forEach var="person" items="${persons}" varStatus="i">
            <c:out value="${i.index + 1}"/> ${person} <br>
        </c:forEach>
    </body>
</html>