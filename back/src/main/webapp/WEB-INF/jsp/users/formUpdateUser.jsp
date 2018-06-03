<%@ include file ="../tags/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Modifier son compte</h1>
<form:form method="post" action="" modelAttribute="user">
	<p>
		<label for="email">Email*</label>
		<form:input path="email" type="text" id="email" value="${user.email}"/>
		<form:errors path="email" />

	</p>
	<p>
		<label for="city">City</label>
		<form:input path="city" type="text" id="city" value="${user.city}"/>
		<form:errors path="city" />
	</p>
		<!--  Eviter le password null -->
		<form:hidden path="password" value="${user.password}" />
	<p>
		<input type="submit" value="valider" />
	</p>
</form:form>

<a href = "/users/changePassword/${user.id}">Changer son mot de passe</a>

<%@ include file ="../tags/footer.jsp" %>