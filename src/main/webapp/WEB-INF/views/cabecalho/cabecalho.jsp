<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>

<head>
	<meta charset="utf-8">
	<link href="<c:url value="/resources/bootstrap-4.1.0/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo03"
				aria-controls="navbarTogglerDemo03" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand" href="/filmesonline"><img src="<c:url value="/resources/img/netflix.png"/>" height="38"></a>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item"><a class="nav-link" href="<c:url value="/filme/lancamento"/>">Lançamentos</a></li>
					<li class="nav-item dropdown">
			            <a class="nav-link dropdown-toggle" href="#" id="dropdown08" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gêneros</a>
			            <div class="dropdown-menu" aria-labelledby="dropdown08">
			            	<a class="dropdown-item" href="<c:url value="/filme/genero/1"/>">Ação</a>
			            	<a class="dropdown-item" href="<c:url value="/filme/genero/2"/>">Aventura</a>
			            	<a class="dropdown-item" href="<c:url value="/filme/genero/3"/>">Comédia</a>
			            	<a class="dropdown-item" href="<c:url value="/filme/genero/4"/>">Terror</a>
			            	<a class="dropdown-item" href="<c:url value="/filme/genero/5"/>">Ficção Científica</a>
			            </div>
			    	</li>
			    	<c:if test='${sessionScope.usuarioLogado != null}'>
						<li class="nav-item dropdown">
				            <a class="nav-link dropdown-toggle" href="#" id="dropdown08" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Área Administrativa</a>
				            <div class="dropdown-menu" aria-labelledby="dropdown08">
								<a class="dropdown-item" href="<c:url value="/filme/form"/>">Cadastrar Filme</a>
				            </div>
				    	</li>
			    	</c:if>
				</ul>
				
				<c:choose>
					<c:when test="${sessionScope.usuarioLogado == null}">
						<a class="btn btn-success" href="<c:url value="/usuario/administrador"/>">Entrar</a>
					</c:when>
					
					<c:when test="${sessionScope.usuarioLogado != null}">
						<a class="btn btn-danger" href="<c:url value="/logout"/>">Sair</a>
					</c:when>
				</c:choose>
			</div>
		</div>
	</nav>