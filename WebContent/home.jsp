<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Les Spectacles</title>
<style type="text/css">
	<%@ include file="/style.css" %>
</style>
</head>

<body>
<%@ include file="menu.jsp" %>
	<c:if test="${!empty sessionScope.user && sessionScope.user.is_admin}">
		<div>
			<a href="form_spectacle">Ajouter Un spectacle</a>
		</div>
	</c:if>
	<p class="success">${success}</p>
	<div>
		<c:choose>
			<c:when test="${spectacles.size() == 0}">
				Pas de spectacles en cours
			</c:when>
			<c:otherwise>
			<div class="liste">
				<c:forEach items="${spectacles}" var="spectacle">
					<div class="spectacle">
						<b>${ spectacle.name }</b>
						<div>${ spectacle.date }</div>
						<div>${ spectacle.details }</div>
						<c:choose>
							<c:when test="${!empty sessionScope.user }">
								<a href="form_reservation?event=${ spectacle.id }">Reserver</a>
								<c:if test="${!empty sessionScope.user.is_agent }">
									<a href="form_abonner?event=${ spectacle.id }">Abonner</a>
								</c:if>
								<c:if test="${!empty sessionScope.user.is_admin }">
									<a href="#">Modifier</a>
								</c:if>
							</c:when>
							<c:otherwise>
								<a href="login">Reserver</a>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
			</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>

</html>