<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Amores Caninos - Selección de preferencias</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<style type="text/css">
		.form-wrapper, .btn-wrapper {
			max-width: 350px;
		}
		@media (max-width: 350px) {
			.form-wrapper, .btn-wrapper {
				margin-left: 1rem;
				margin-right: 1rem;
			}	
		}
	</style>
</head>
<body>

	<%@ include file="header.html" %>

	<main>
		<h2 class="mb-4 ml-4">Búsqueda de perfiles</h2>
		<form action="match" method="POST" class="form-wrapper my-2 mx-auto">
			<div class="form-group">
				<label class="" for="raza">Raza</label>
				<select class="form-control" name="raza-id" id="raza">
					<option value="0" selected>Todas</option>
					<c:forEach items="${razas}" var="raza">
						<option value="${raza.getId()}">${raza.getNombre()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="genero">Género</label>
				<select class="form-control" name="genero" id="genero">
					<option value="Todos" selected>Todos</option>
					<c:forEach items="${generos}" var="genero">
						<option value="${genero}">${genero}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="edad">Edad</label>
				<select class="form-control" name="edad" id="edad">
					<option value="0" selected>Todas</option>
					<c:forEach items="${edades}" var="edad">
						<option value="${edad}">${edad}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="caracteristica">Característica</label>
				<select class="form-control" name="caracteristica-id" id="caracteristica">
					<option value="0" selected>Todas</option>
					<c:forEach items="${caracteristicas}" var="caract">
						<option value="${caract.getId()}">${caract.getNombre()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<button class="btn btn-success" type="submit">Buscar</button>
			</div>
		</form>
		<div class="btn-wrapper mb-5 mx-auto">
			<a class="btn btn-primary d-inline-block" href="viewall">Ver todos</a>
			<a class="btn btn-secondary d-inline-block ml-auto" href="/">Volver al inicio</a>
		</div>
	</main>
	
	<%@ include file="footer.html" %>
	
</body>
</html>