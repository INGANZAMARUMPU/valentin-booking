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
<p class="erreur">${erreur}</p>
<div class="ticket">
	<div class="titre jaune">
		<div>${ reservation.spectacle.date }</div>
		<div>${ reservation.spectacle.details }</div>
	</div>
	<div class="name jaune">${ reservation.spectacle.name }</div>
	<div class="numero jaune">ticket numero ${ reservation.spectacle.id }</div>
	<div>${ reservation.personne.username }</div>
	<div>${ reservation.spectacle.prix } Fbu</div>
	<div class="placement">Placement libre</div>
</div>
<div><button>Imprimer</button></div>

</body>
</html>