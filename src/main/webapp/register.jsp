<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<body>
<jsp:include page="/Shared/header.jsp"></jsp:include>
	<div class="container">
		<div class="row text-center mt-5" style="color: tomato;">
			<h2>Ajout d'offre</h2>
		</div>
		<hr>
		<div >
			<div class=" row col-md-6">
				<div class="card card-body">
					<div class="col-md-12 col-md-offset-3">
						<form
							action="<%=request.getContextPath()%>/UserController/inserer"
							method="post">

							<div class="form-group">
								<label for="titre">Titre:</label> <input type="text"
									class="form-control" id="titre" placeholder="Titre de l'offre"
									name="titre" required>
							</div>

							<div class="form-group">
								<label for="description">description:</label>
								<textarea type="text" class="form-control" id="description"
									placeholder="description de l' offre" rows="3"
									name="description" required></textarea>
							</div>

							<div class="form-group col-md-4">
								<label for="inputType">Type</label> <select id="inputType"
									name="inputType" class="form-select">
									<option value="cdi">CDI</option>
									<option value="cdd">CDD</option>
									<option value="stage">Stage</option>
								</select>
							</div>

							<button type="submit" class="btn btn-primary mt-5">Submit</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>