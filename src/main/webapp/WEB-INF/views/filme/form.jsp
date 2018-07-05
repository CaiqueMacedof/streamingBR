<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../cabecalho/cabecalho.jsp"></c:import>

<div class="container">
	<div class="row">
		<div class="col-md-12 order-md-1">
			<h1 class="mt-4">Cadastro de Filme</h1>
			
			<c:if test="${resposta.isSucesso()}">
				<div class="alert ${resposta.getClasseAlerta()}">
		  			${resposta.getMensagem()}
				</div>
			</c:if>
			
			<form id="datas" class="needs-validation"
				action="<c:url value='/filme/inserir' />" method="POST" enctype="multipart/form-data" novalidate>
				
				<div class="mb-3">
					<label for="username">Nome</label> <input type="text"
						class="form-control" name="nome" />
				</div>

				<div class="mb-3">
					<label for="descricao">Descrição</label>
					<textarea name="descricao" class="form-control"></textarea>
				</div>

				<div class="mb-3">
					<label for="ano">Ano</label> <input type="text"
						class="form-control" name="ano" required />
				</div>

				<div class="mb-3">
					<label for="classificacao">Classificação</label> <input type="text"
						class="form-control" name="classificacao[0].pontuacao" />
				</div>

				<div class="mb-3">
					<label for="genero">Gênero</label> <select name="genero.id"
						class="custom-select d-block w-100" required>
						<option value="">Escolha...</option>
						<c:forEach items="${generos}" var="genero">
							<option value="${genero.id }">${genero.nome }</option>
						</c:forEach>
					</select>
				</div>

				<div class="mb-3">
					<label for="imagem">Imagem</label> <input type="file"
						class="form-control" name="imagem" />
				</div>
				
				<hr class="mb-4">
				<button class="btn btn-primary btn-lg btn-block" type="submit" >Cadastrar</button>
			</form>
			
			<!-- form id="upload" action="<c:url value='/filme/upload' />" method="POST"
				enctype="multipart/form-data">
			</form-->

		</div>
	</div>
</div>

<c:import url="../rodape/rodape.jsp"></c:import>