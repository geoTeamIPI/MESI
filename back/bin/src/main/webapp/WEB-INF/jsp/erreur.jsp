<%@ include file ="../tags/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="alert alert-danger alert-dismissible" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    Please enter the required datas
    
    <th:if test="${!empty errSearchingUser }">
		${errSearchingUser}
	</th:if>
</div>

<%@ include file ="../tags/footer.jsp" %>
