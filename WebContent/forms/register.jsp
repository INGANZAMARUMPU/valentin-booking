<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>S'enregistrer</title>
<style type="text/css">
	<%@ include file="/style.css" %>
</style>
</head>
<body>

<%@ include file="../menu.jsp" %>

<form action="register" method="post">
	<p class="erreur">${erreur}</p>
	<div>
		<label for="username">Nom d'utilisateur</label>
		<br>
		<input type="text" id="username" name="username"/>
	</div>
	<div>
		<label for="email">email</label>
		<br>
		<input type="email" id="email" name="email"/>
	</div>
	<div>
		<label for="password">mot de passe</label>
		<br>
		<input type="password" id="password" name="password"/>
	</div>
	<div>
		<label for="confirm">confirmation</label>
		<br>
		<input type="password" id="confirm" name="confirm"/>
	</div>
	<div>
		<label for="domicile">Addresse complet</label>
		<br>
		<input type="text" id="domicile" name="domicile"/>
	</div>
	<input type="submit" value="envoyer"/>
</form>

</body>
</html>