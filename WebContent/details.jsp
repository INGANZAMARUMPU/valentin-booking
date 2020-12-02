<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>reservation</title>
<style type="text/css">
	<%@ include file="/style.css" %>
</style>
</head>
<body>

<%@ include file="../menu.jsp" %>

<c:forEach items="${reservations}" var="reservation">
	
	<div class="reservation">
		<div>${ reservation.personne.username }</div>
		<div>${ reservation.personne.email }</div>
		<div>${ reservation.spectacle.name }</div>
		<div>${ reservation.spectacle.date }</div>
		<div><a href="details?&reservation=${ reservation.id }">Detail</a></div>
	</div>
</c:forEach>

</body>
</html>