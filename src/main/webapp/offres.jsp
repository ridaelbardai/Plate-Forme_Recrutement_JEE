<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Offres</title>

</head>
<body>
	<jsp:include page="/Shared/header.jsp"></jsp:include>

	<div class="container col-6">

		<c:forEach items="${lo}" var="item">
			<div class="card mt-3">
				<div class="card-header">
					<div class="card-title fw-bold">
						<c:out value='${item.getTitre()}' />
					</div>
					<div class="card-title d-flex justify-content-end">
						<c:out value='${item.getDate()}' />
					</div>
				</div>
				<div class="card-body">
					<c:out value='${item.getType().getLibelle()}' />
					<p class="card-text">
						<c:out value='${item.getDescription()}' />
					</p>
					<c:if test="${user.getType() == 'a'}">
						<a class="btn btn-primary"
							href="<%=request.getContextPath()%>/UserController/modifier?id=${item.getId()}"
							class="card-link">Modifier</a>
						<a class="btn btn-primary"
							href="<%=request.getContextPath()%>/UserController/supprimer?id=${item.getId()}"
							class="card-link">Supprimer</a>
							
							<a class="btn btn-primary"
							href="<%=request.getContextPath()%>/UserController/demandes?id=${item.getId()}"
							class="card-link">voir demandes</a>
					</c:if>

					<c:if test="${user.getType() == 'u'}">
						<a class="btn btn-primary"
							href="<%=request.getContextPath()%>/UserController/demande?id=${item.getId()}"
							class="card-link">Postuler</a>
					</c:if>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>