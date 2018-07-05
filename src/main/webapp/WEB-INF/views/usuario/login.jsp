<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value="/resources/bootstrap-4.1.0/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet" type="text/css">
	<title>Administrador</title>
</head>

<body class="text-center">
	
	<form action="<c:url value='/usuario/entrar' />" method="POST" class="form-signin">
		<img class="mb-4" src="<c:url value='/resources/img/netflix.png' />" alt="" height="72">
		<c:if test="${mensagemLogin.isSucesso() == false}">
			<div class="alert alert-danger">
	  			${mensagemLogin.getMensagem()}
			</div>
		</c:if>
		
		<label for="inputEmail" class="sr-only">E-mail</label>
		<input type="text" name="usuario" class="form-control" placeholder="Email" required="required" autofocus="autofocus">
		
		<label for="inputPassword" class="sr-only">Senha</label>
		<input type="password" name="senha" class="form-control" placeholder="Senha" required="required">
		
		<div class="checkbox mb-3">
		  <label>
		    <input type="checkbox" value="remember-me"> Lembra-me
		  </label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		<p class="mt-5 mb-3 text-muted">© 2017-2018</p>
    </form>
</body>
</html>