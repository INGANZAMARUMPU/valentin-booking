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
<br>
Rechercher un client
<form action="form_abonner?recherche=1" method="post">
	<p class="erreur">${erreur}</p>
	<label for="username">Username</label>
	<input type="text" id="username" name="username"/>
	<input type="submit" value="recherche"/>
</form>
<hr>
Informations du client
<form action="form_abonner" method="post">
	<p class="erreur">${erreur}</p>
	<div>
		<label for="username">Nom d'utilisateur</label>
		<br>
		<input type="text" id="username" name="username" value="${ personne.username }"/>
	</div>
	<div>
		<label for="email">email</label>
		<br>
		<input type="email" id="email" name="email"  value="${ personne.email }"/>
	</div>
	<div>
		<label for="domicile">Addresse complet</label>
		<br>
		<input type="text" id="domicile" name="domicile" value="${ personne.domicile }"/>
	</div>
	<div>
		<label for="places">Nombre de places</label>
		<br>
		<input type="number" id="places" name="places" value="1"/>
	</div>
	<input type="submit" value="envoyer"/>
</form>

</body>
</html>