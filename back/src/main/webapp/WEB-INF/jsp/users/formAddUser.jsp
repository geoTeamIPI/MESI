<%@ include file ="../tags/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Create a new user</h1>
<form method="post" action="">
	<p>
		<label for="email">Email*</label>
		<input type="text" name="email" />

	</p>
	<p>
		<label for="password">Password*</label>
		<input type="password" name="password" />
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

<c:if test="${show == false }" >
	<ul>
		<c:if test="${!empty emptyEmail}">
			<li>${emptyEmail}</li>
		</c:if>
		<c:if test="${!empty emptyPassword}">
			<li>${emptyPassword}</li>
		</c:if>
		<c:if test="${!empty notEqualPasswords}">
			<li>${notEqualPasswords}</li>
		</c:if>
	</ul>
</c:if>

<c:if test="${show == true }" >
	Voici les résultats de la soumission : 
	<ul><li>Email : ${email} </li>
		<li> Password : ${password}</li>
		<li> City : ${city} </li>
		<li>Profile : ${profile}</li>
	</ul>
</c:if>


<%@ include file ="../tags/footer.jsp" %>