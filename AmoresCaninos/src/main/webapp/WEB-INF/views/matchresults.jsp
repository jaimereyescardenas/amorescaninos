<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Amores Caninos - Resultados</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
	<style type="text/css">
		.perfil-wrapper {
			max-width: 578px;
		}
		.form-wrapper, .btn-wrapper {
			max-width: 350px;
			margin-left: auto;
			margin-right: auto;
		}
	</style>
</head>
<body>

	<%@ include file="header.html" %>  

	<main>
		<h2 class="mb-4 ml-4">Perfiles</h2>
		<c:if test="${perfiles.size() == 0}">
			<p class="lead text-center p-5">No hay perfiles que coincidan con tus preferencias. Lo sentimos &#128542;</p>
		</c:if>
	
		<c:forEach items="${perfiles}" var="perfil">
			<div class="perfil-wrapper border border-secondary rounded p-3 my-2 mx-sm-auto mx-2">
				<div class="media">
		  			<div class="media-body">
		    			<h5 class="mt-0 mb-1 mr-auto">${perfil.getNombre()} <small class="font-weight-normal">${perfil.getRaza().getNombre()}</small></h5>
		    			<span>${perfil.getGenero()}, ${perfil.getEdad()} años</span>
		    			<div>
		    				<p><em>${perfil.getFrase()}</em></p>
		    				<p>
								<c:forEach items="${perfil.getCaracteristicas()}" var="caract">
									<span class="badge badge-pill badge-info">${caract.getNombre()}</span>
								</c:forEach>
							</p>
		    			</div>
		  			</div>
	  			<img class="d-flex ml-3 rounded" alt="${perfil.getNombre()}" src="${perfil.getUrlImagen()}" width="100" height="100">
				</div>
			</div>
		</c:forEach>
		
		<div class="btn-wrapper mt-3 mb-5">
			<a class="btn btn-secondary d-inline-block ml-3" href="/">Volver al inicio</a>
		</div>
	</main>

	<%@ include file="footer.html" %>

</body>
</html>