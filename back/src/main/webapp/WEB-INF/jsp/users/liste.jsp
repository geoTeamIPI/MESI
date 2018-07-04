<%@ include file ="../tags/header.jsp" %>

<table>
	<th:choose>
	<th:when test="${previousPage < 0 }">
		<th>
			<a href="/users?page=0&size=${ size }&sortProperty=email&sortDirection=${sortDirection}">Email</a>
		</th>
	</th:when>
	<th:otherwise>
		<th>
			<a href="/users?page=${ previousPage }&size=${ size }&sortProperty=email&sortDirection=${sortDirection}">Email</a>
		</th>
	</th:otherwise>
	</th:choose>
	<th colspan="3">Actions</th>
	<th:forEach items="${users}" var="user">
	<tr>
		<td>Email : ${user.email}</td>
		<td><a href="user/infos/${user.id}">Détails</a></td>
		<td><a href="user/update/${user.id}">Modifier</a></td>
		<td><a href="user/delete/${user.id}">Supprimer</a></td>
	</tr>
	</th:forEach>
</table>

<th:if test="${hasPrevious}">
	<a href="/users?page=${ previousPage }&size=${ size }&sortProperty=${ sortProperty }&sortDirection=${ sortDirection }">&laquo;</a>
</th:if>
   <a href="#">Page ${page}</a>
<th:if test="${hasNext}">
	<a href="/users?page=${ nextPage }&size=${ size }&sortProperty=${ sortProperty }&sortDirection=${ sortDirection }">&raquo;</a>
</th:if>

<%@ include file ="../tags/footer.jsp" %>
