<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/Shared/header.jsp"></jsp:include>
	<div class="container">
		<p class="fw-bolder">Ajouter votre CV et une LM pour votre
			candidature :</p>
		<div class="mt-5 col-md-6">
			<form method="post"
				action="<%=request.getContextPath()%>/UserController/postuler"
				enctype="multipart/form-data">


				<input type="hidden" name="id"
					value="<%=request.getParameter("id")%>">
				<p class="fw-normal mt-5">CV :</p>
				<div class="input-group ">
					<input class="form-control" type="file" name="cv" />
				</div>
				<p class="fw-normal mt-5">LM :</p>
				<div class="input-group mb-5">
					<input class="form-control" type="file" name="lm" />
				</div>

				<input type="submit" class="btn btn-success" value="Ajouter" />
			</form>
		</div>
	</div>
</body>
</html>