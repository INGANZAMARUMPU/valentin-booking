<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>connexion</title>
</head>
<body>

<%@ include file="../menu.jsp" %>

<form action="login" method="post">
	<p class="erreur">${erreur}</p>
	<div>
		<label for="username">Nom d'utilisateur</label>
		<br>
		<input type="text" id="username" name="username"/>
	</div>
	<div>
		<label for="password">mot de passe</label>
		<br>
		<input type="password" id="password" name="password"/>
	</div>
	<input type="submit" value="connexion"/>
</form>

</body>
</html>