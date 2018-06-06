<%@ include file ="../tags/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>

<th:if test="${SessionScope.user.email ==  null}">
	Email : ${user.email} <br />
	Ville : ${user.city} <br />
	Profil : ${user.profile}
</th:if>

<%@ include file="../tags/footer.jsp" %>