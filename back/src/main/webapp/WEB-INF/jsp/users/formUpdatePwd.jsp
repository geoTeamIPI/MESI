<%@ include file ="../tags/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Changer le mot de passe</h1>
<form:form method="post" action="" modelAttribute="user">
	<p>
		<label for="oldPassword">Ancien mot de passe</label>
		<form:input path="oldPassword" type="password" id="oldPassword"/>
		<form:errors path="oldPassword" />
	</p>
	<p>
		<label for="password">Nouveau mot de passe</label>
		<form:input path="password" type="password" id="password" />
		<form:errors path="password" />
	</p>
	<p>
		<label for="passwordConfirm">Confirmer le nouveau mot de passe</label>
		<form:input path="passwordConfirm" type="password" id="passwordConfirm" />
		<form:errors path="passwordConfirm" />
	</p>
		<form:hidden path="email" value="${user.email}" />
		<form:hidden path="city" value="${user.city}" />
	<p>
		<input type="submit" value="valider" />
	</p>
</form:form>

<th:if test="${!empty notMatchedPwd}">
	${notMatchedPwd}
</th:if>

<th:if test="${!empty pwdNoExists}">
	${pwdNoExists}
</th:if>

Ancien mot de passe : ${oldPwdEncode}
Mot de passe actuel : ${currentPwdEncode}


<%@ include file ="../tags/footer.jsp" %>