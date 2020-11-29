<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout Spectacle</title>
</head>
<body>

<%@ include file="../menu.jsp" %>

<form action="form_spectacle" method="post">
	<div>
		<label for="name">Nom du spectacle</label>
		<br>
		<input type="text" id="name" name="name"/>
	</div>
	<div>
		<label for="date">Date</label>
		<br>
		<input type="date" id="date" name="date"/>
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
		<label for="details">Details</label>
		<br>
		<input type="text" id="details" name="details"/>
	</div>
	<input type="submit" value="envoyer"/>
</form>

</body>
</html>