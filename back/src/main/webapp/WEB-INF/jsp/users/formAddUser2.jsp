<%@ include file ="../tags/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>

<h1>Create a new user</h1>
<form method="post" action="" th:action="@{/new}" th:object="${userForm}">
	<p>
		<label for="email">Email*</label>
		<input type="text" name="email" />
		<th:if test="${#fields.hasErrors('email')}" th:errors="*{email}">Email Error</th:if>

	</p>
	<p>
		<label for="password">Password*</label>
		<input type="password" name="password" />
		<th:if test="${#fields.hasErrors('password')}" th:errors="*{password}">Password Error</th:if>
	</p>
	<p>
		<label for="passwordConfirm">Confirm password*</label>
		<input type="password" name="passwordConfirm" />
	</p>
	<p>
		<label for="city">City</label>
		<input type="text" name="city" />
	</p>
	<p>
		<input type="submit" value="valider" />
	</p>
</form>

<th:if test="${!empty success}">
	${success}
</th:if>


<%@ include file ="../tags/footer.jsp" %>