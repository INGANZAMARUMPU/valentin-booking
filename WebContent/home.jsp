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
	<div>
		<c:choose>
			<c:when test="${empty spectacles}">
				Pas de spectacles en cours
			</c:when>
			<c:otherwise>
			
			</c:otherwise>
		</c:choose>
	</div>
</body>

</html>