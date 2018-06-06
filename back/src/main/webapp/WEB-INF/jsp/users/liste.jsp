<%@ page import="org.springframework.data.domain.Page" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix = "th" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file ="../tags/header.jsp" %>


<th:forEach items="${users}" var="user">
	Email : ${user.email}
	<a href="users/details/${user.id}">D</a>
	<a href="users/update/${user.id}">Modifier</a>
	<a href="">Supprimer</a>
	<br />
</th:forEach>

<%@ include file ="../tags/footer.jsp" %>
