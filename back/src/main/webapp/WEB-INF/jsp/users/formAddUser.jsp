<%@ include file ="../tags/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Create a new user</h1>
<form:form method="post" action="" modelAttribute="user">
	<p>
		<label for="email">Email*</label>
		<form:input path="email" type="text" id="email" value = ""/>
		<form:errors path="email" />

	</p>
	<p>
		<label for="password">Password*</label>
		<form:input path="password" type="password" id="password" />
		<form:errors path="password" />
	</p>
	<p>
		<label for="passwordConfirm">Confirm password*</label>
		<form:input path="passwordConfirm" type="password" id="passwordConfirm" />
		<form:errors path="passwordConfirm" />
	</p>
	<p>
		<label for="city">City</label>
		<form:input path="city" type="text" id="city" />
		<form:errors path="city" />
	</p>
	<p>
		<input type="submit" value="valider" />
	</p>
</form:form>

<th:if test="${!empty notMatchedPwd}">
	${notMatchedPwd}
</th:if>
<th:if test="${!empty emailExists}">
	${emailExists}
</th:if>
<th:if test="${!empty success}">
	${success}
</th:if>


<%@ include file ="../tags/footer.jsp" %>