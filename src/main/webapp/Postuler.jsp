<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>Veuillez choisir les images à uploader.</h1>
	</header>

	<form method="post" action="<%=request.getContextPath()%>/UserController/postuler" enctype="multipart/form-data">
    <input type="hidden" value="<%=request.getParameter("id")%>" name="id">
    <input type="file" name="cv" />
    <input type="file" name="lm" />
    <input type="submit" />
  </form>
  
</body>
</html>