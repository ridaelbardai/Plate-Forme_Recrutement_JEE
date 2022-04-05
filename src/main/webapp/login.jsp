<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>
<body>

 <div class="container col-md-3 col-md-offset-3 mb-4" style="overflow: auto">
  <h1>Login Form</h1>
  <form action="<%=request.getContextPath()%>/UserController/login" method="post">
   <div class="form-group mt-5">
    <label for="email">Adresse mail:</label> <input type="text"
     class="form-control" id="email" placeholder="Email"
     name="email" required>
   </div>
   <div class="form-group">
    <label for="uname">Mot de passe:</label> <input type="password"
     class="form-control" id="password" placeholder="Password"
     name="password" required>
   </div>
   <div class="d-flex justify-content-center">
   <button type="submit" class="btn btn-success">Submit</button>
   </div>
  </form>
 </div >
 <div >
  <img style="display: block; margin-left: auto; margin-right: auto;" src="https://www.possibility.fr/wp-content/uploads/2019/05/recrutement-2.png" alt="Italian Trulli">
 </div>
</body>
</html>