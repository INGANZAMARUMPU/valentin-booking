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

<form action="form_reservation" method="post">
	<p class="erreur">${erreur}</p>
	<div>
		<label for="places">Places</label>
		<br>
		<input type="number" id="places" name="places"/>
	</div>
	<div>
		<label for="livraison">Livraison</label>
		<input type="checkbox" id="livraison" name="livraison"/>
	</div>
	<input type="submit" value="envoyer"/>
</form>

</body>
</html>