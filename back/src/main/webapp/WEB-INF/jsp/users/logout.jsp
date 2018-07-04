<%@ include file ="../tags/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>

<th if test="${!empty logoutSuccess}">
	${logoutSuccess}
</th>

<%@ include file="../tags/footer.jsp" %>