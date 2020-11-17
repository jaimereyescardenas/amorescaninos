<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amores Caninos - Resultados</title>
</head>
<body>

	<c:forEach items="${perfiles}" var="perfil">
		<div>
			<p>--- Perfil ${perfil.getId()} ---</p>
			<p>Nombre: ${perfil.getNombre()}</p>
			<p>Raza: ${perfil.getRaza().getNombre()}</p>
			<p>Género: ${perfil.getGenero()}</p>
			<p>Edad: ${perfil.getEdad()}</p>
			<p>Frase: ${perfil.getFrase()}</p>
			<img alt="${perfil.getNombre()}" src="${perfil.getUrlImagen()}" width="100" height="100">
			<p>----------------</p>
		</div>
	</c:forEach>
	

	<a href="/">Volver al inicio</a>

</body>
</html>