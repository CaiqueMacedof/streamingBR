<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../cabecalho/cabecalho.jsp"></c:import>

<div class="container">
	<h1 class="mt-4">
		<c:choose>
         <c:when test = "${filmes.getNome() != null}">
            ${filmes.getNome()}
         </c:when>
         
         <c:otherwise>
            Lançamentos
         </c:otherwise>
      </c:choose>
	</h1>
	
	<div class="album py-4">
		<div class="container">
			<div class="row">
				<c:forEach var="filme" items="${filmes.filme}">
					<div class="col-md-3 col-sm-3 col-lg-3">
						<div class="card mb-4">
							<img class="card-img-top img-responsive"
								src="<c:url value="${filme.caminhoImagem}" />"
								data-holder-rendered="true"
								height="240">
							<div class="card-body" style="padding:18px;min-height:100px;">
								<p class="card-text">${filme.nome}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

<c:import url="../rodape/rodape.jsp"></c:import>