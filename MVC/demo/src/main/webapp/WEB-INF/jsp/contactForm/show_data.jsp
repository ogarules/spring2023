<%@ page language="java" contentType="text/html charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
    <head>Success</head>
    <body>
        <strong>${contactForm.name}</strong> (${contactForm.gender})
        <br>
        <br>
        Your request has been processed. We will contact you on
        <strong>${contactForm.email}</strong> for the following courses;
        <c:forEach var="course" items="${contactForm.courses}">
            <c:out value="${course}"/><br>
        </c:forEach>

        <br>
        ${contactForm.tutor} will be your tutor
        <br>
        hidden message ${confirmationId}
    </body>
</html>