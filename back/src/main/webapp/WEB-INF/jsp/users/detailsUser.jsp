<%@ include file ="../tags/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>

<p> Email : ${user.email} </p>
<p>Ville : ${user.city}</p>
<p>Profil : ${user.profile}</p>

<th:choose>
	<th:when test="${empty idUser}">
		<a href="/user/update/${idUser}">Modifier mes informations</a>
	</th:when>
	<th:otherwise>
		<a href="/user/update">Modifier ses informations</a>
	</th:otherwise>
</th:choose>

<%@ include file="../tags/footer.jsp" %>