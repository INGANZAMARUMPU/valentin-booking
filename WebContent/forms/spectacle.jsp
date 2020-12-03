<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout Spectacle</title>
<style type="text/css">
	<%@ include file="/style.css" %>
</style>
</head>
<body>

<%@ include file="../menu.jsp" %>

<form class="form" action="form_spectacle" method="post">
	<p class="erreur">${erreur}</p>
	<div>
		<label for="name">Nom du spectacle</label>
		<br>
		<input type="text" id="name" name="name"/>
	</div>
	<div>
		<label for="date">Date</label>
		<br>
		<input type="date" id="date" name="date" placeholder="yyyy-MM-dd"
			min="2020-12-01" max="2030-12-31"/>
	</div>
	<div>
		<label for="places">Places</label>
		<br>
		<input type="number" id="places" name="places"/>
	</div>
	<div>
		<label for="prix">Prix</label>
		<br>
		<input type="number" id="prix" name="prix"/>
	</div>
	<div>
		<label for="details">Lieu</label>
		<br>
		<input type="text" id="details" name="details"/>
	</div>
	<input type="submit" value="envoyer"/>
</form>

</body>
</html>