<%@ include file ="../tags/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>

<p>
	<th if test="${!empty successUserCreated}">
		${successUserCreated}
	</th>
	
	<th if test="${!empty successUserUdpated}">
		${successUserUdpated}
	</th>
	
	<th if test="${!empty pwdUpdated}">
		${pwdUpdated}
	</th>
	
	<th if test="${!empty successIdentification}">
		${successIdentification}
	</th>
</p>


<%@ include file ="../tags/footer.jsp" %>