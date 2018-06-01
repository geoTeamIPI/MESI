<%@ page import="org.springframework.data.domain.Page" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file ="../tags/header.jsp" %>

<c:forEach items="${users}" var="user">
	Email : ${user.email}
	<a href="users/${user.id}">modifier</a>
	<br />
</c:forEach>

<%@ include file ="../tags/footer.jsp" %>
