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
		<b>${ reservation.personne }</b>
		${ reservation.spectacle }
		<a href="#">envoyer</a>
	</div>
</c:forEach>

</body>
</html>