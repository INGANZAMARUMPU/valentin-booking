<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="menu">
	<a href="home">accueil</a>
	<c:choose>
		<c:when test="${sessionScope.user == null}">
			<a href="login">connexion</a>
			<a href="register">s'abonner</a>
		</c:when>
		<c:otherwise>
			<a href="home?logout=1">deconnexion</a>
		</c:otherwise>
	</c:choose>
</div>