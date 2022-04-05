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

	<form method="post" action="<%=request.getContextPath()%>/UserController/postuler" enctype="multipart/form-data">
		<input type="hidden" name="id" value="<%=request.getParameter("id")%>"> 
		<input type="file" name="cv" /> 
		<input type="file" name="lm" /> <input type="submit" value="Upload" />
	</form>
</body>
</html>