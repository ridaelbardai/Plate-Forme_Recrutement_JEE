<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="/Shared/header.jsp"></jsp:include>
<body>
	<div class="container col-md-8 ">
		<div class="card mt-5 ">

			<div class="card-body">
				<c:out value='liste des demandes pour l\'offre \" ${off.getTitre()} \"'></c:out>
			</div>
		</div>
		<div class="d-flex justify-content-center">
			<c:forEach items='${mo}' var="dm">
				<div
					class="card text-dark bg-light mb-3 mt-5 col-md-6 col-xs-1 text-center">
					<div class="card-header">Date : ${dm.getDate()}</div>
					<div class="card-body">
						<h5 class="card-title">
							<c:out
								value='${dm.getDemandeur().getFirstName()} ${dm.getDemandeur().getLastName()}'></c:out>
						</h5>
						<p class="card-text">
							<a class="mx-3"
								href="<%=request.getContextPath()%>/UserController/DownloadServlet?nom=${dm.getCv()}"><img
								alt="CV"
								src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/PDF_file_icon.svg/833px-PDF_file_icon.svg.png"
								width=40 "height="40">cv</a> 
							<a
								href="<%=request.getContextPath()%>/UserController/DownloadServlet?nom=${dm.getLm()}"><img
								alt="LM"
								src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/PDF_file_icon.svg/833px-PDF_file_icon.svg.png"
								width=40 "height="40">Lm</a>
						</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


</body>
</html>

