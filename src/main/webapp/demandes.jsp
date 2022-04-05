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
	<c:forEach items='${mo}' var="dm">
		<a href="<c:out value='${dm.getCv()}' />">cv</a>
		<a href="<%=request.getContextPath()%>/UserController/DownloadServlet?nom=${dm.getCv()}">Données</a>
		

	</c:forEach>
</body>
</html>

