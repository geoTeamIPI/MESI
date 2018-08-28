<%@ include file ="../tags/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form method="post" action="login" modelAttribute="user">
	<p>
		<label for="email">Email*</label>
		<form:input path="email" type="text" id="email" />
		<form:errors path="email" />

	</p>
	<p>
		<label for="password">Password*</label>
		<form:input path="password" type="password" id="password" />
		<form:errors path="password" />
	</p>
	
		<form:hidden path="city" value="nonNull" />
	<p>
		<input type="submit" value="valider" />
	</p>
</form:form>
Pas encore inscrit, cliquez <a href="/user/new">ici</a>

<th:if test="${!empty errIdentification}">
	${errIdentification}
</th:if>

<%@ include file="../tags/footer.jsp" %>