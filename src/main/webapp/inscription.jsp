<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
		<div class="row col-md-10 col-md-offset-3">
			<div class="card card-body">
				<h1>Inscription</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<form method="post" action="<%=request.getContextPath()%>/UserController/inscription">
			<div class="form-group row mt-5">
				<label for="nom" class="col-sm-2 col-form-label">Nom :</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="nom" name="nom">
				</div>
			</div>


			<div class="form-group row mt-5">
				<label for="prenom" class="col-sm-2 col-form-label">Prenom :</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="prenom" id="prenom">
				</div>
			</div>

			<div class="form-group row mt-5">
				<label for="email" class="col-sm-2 col-form-label">Email :</label>
				<div class="col-sm-3">
					<input type="email" name="email" class="form-control" id="email">
				</div>
			</div>
			
			<div class="form-group row mt-5">
				<label for="password" class="col-sm-2 col-form-label">Password :</label>
				<div class="col-sm-3">
					<input type="password" class="form-control" name="password" id="password">
				</div>
			</div>


			<div class="form-group row mt-5">
				<div class="col-sm-3">
					<button type="submit" class="btn btn-primary">Sign in</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>