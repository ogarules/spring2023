<%@ page language="java" contentType="text/html charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>Detalle d ela persona creada</head>
    <body>
        <h1>Persona creada yey!!!</h1>
        <h2>${personCreated} was created at: ${servertime}</h2>

        <a href="${pageContext.request.contextPath}/person">Regresar</a>
    </body>
</html>