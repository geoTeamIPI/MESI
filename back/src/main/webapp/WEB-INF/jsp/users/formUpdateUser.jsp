<%@ include file ="../tags/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h3>Modification de compte</h3>
<form:form method="post" action="" modelAttribute="user">
	<p>
		<label for="email">Email*</label>
		<form:input path="email" type="text" id="email" value="${user.email}"/>
		<form:errors path="email" />

	</p>
	<p>
		<label for="city">Ville*</label>
		<form:input path="city" type="text" id="city" value="${user.city}"/>
		<form:errors path="city" />
	</p>
	<th:if test="${!empty sProfile && (sProfile == userAdmin || sProfile == userModerator)}">
	<p>
		<label for="city">Profile</label>
		<form:select path="profile" type="text" id="profile">
			<th:choose>
				<th:when test="${user.profile == userNormal}">
					<form:option value="${userNormal}" selected="selected">${userNormal}</form:option>
					<form:option value="${userModerator}">${userModerator}</form:option>
					<form:option value="${userAdmin}">${userAdmin}</form:option>
				</th:when>
				<th:when test="${user.profile  == userModerator}">
					<form:option value="${userNormal}">${userNormal}</form:option>
					<form:option value="${userModerator}" selected="selected">${userModerator}</form:option>
					<form:option value="${userAdmin}">${userAdmin}</form:option>
				</th:when>
				<th:otherwise>
					<form:option value="${userNormal}">${userNormal}</form:option>
					<form:option value="${userModerator}">${userModerator}</form:option>
					<form:option value="${userAdmin}" selected="selected">${userAdmin}</form:option>
				</th:otherwise>
			</th:choose>
		</form:select>
		<form:errors path="profile" />
	</th:if>
	</p>
		<!--  Eviter le password null -->
		<form:hidden path="password" value="${user.password}" />
	<p>
		<input type="submit" value="valider" />
	</p>
</form:form>


<th:if test="${empty idUser}">
	<a href = "/user/changePassword">Changer mon mot de passe</a>
</th:if>

<%@ include file ="../tags/footer.jsp" %>