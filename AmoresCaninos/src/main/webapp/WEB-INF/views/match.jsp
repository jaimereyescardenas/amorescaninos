<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amores Caninos - Selección de preferencias</title>
</head>
<body>

	<form action="match" method="POST">
		<div class="form-group">
			<label for="raza">Raza</label>
			<select name="raza-id" id="raza">
				<option value="0" selected>Todas</option>
				<c:forEach items="${razas}" var="raza">
					<option value="${raza.getId()}">${raza.getNombre()}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="genero">Género</label>
			<select name="genero" id="genero">
				<option value="Macho">Macho</option>
				<option value="Hembra">Hembra</option>
				<option value="Ambos" selected>Ambos</option>
			</select>
		</div>
		<div class="form-group">
			<label for="edad">Edad</label>
			<input type="number" name="edad" id="edad" min="0" max="15" value="0">
		</div>
		<div class="form-group">
			<label for="caracteristica">Característica</label>
			<select name="caracteristica-id" id="caracteristica">
				<option value="0" selected>Todas</option>
				<c:forEach items="${caracteristicas}" var="caract">
					<option value="${caract.getId()}">${caract.getNombre()}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			
		</div>
		<div class="form-group">
			<button type="submit">Buscar</button>
		</div>
	</form>

	<a href="viewall">Ver perfiles</a>
	<a href="/">Volver al inicio</a>

</body>
</html>