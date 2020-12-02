<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="menu">
	<a href="home">accueil</a>
	<c:choose>
		<c:when test="${empty sessionScope.user}">
			<a href="login">connexion</a>
			<a href="register">s'abonner</a>
		</c:when>
		<c:otherwise>
			<c:if test="${!empty sessionScope.user && sessionScope.user.is_admin}">
				<div>
					<a href="#spectacles">spectacles</a>
				</div>
			</c:if>
			<a href="home?logout=1">deconnexion</a>
		</c:otherwise>
	</c:choose>
</div>