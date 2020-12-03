<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>connexion</title>
<style type="text/css">
	<%@ include file="/style.css" %>
</style>
</head>
<body>

<%@ include file="../menu.jsp" %>

<form action="login" class="form" method="post">
	<p class="erreur">${erreur}</p>
	<div>
		<label for="username">Nom d'utilisateur</label>
		<br>
		<input type="text" id="username" required name="username"/>
	</div>
	<div>
		<label for="password">mot de passe</label>
		<br>
		<input type="password" id="password" required name="password"/>
	</div>
	<input type="submit" value="connexion"/>
</form>

</body>
</html>