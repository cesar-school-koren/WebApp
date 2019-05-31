<%@ tag language="java" pageEncoding="ISO-8859-1" body-content="scriptless"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:if test="${sessionScope.conta == null}">
	<c:redirect url= "homeNotLoggedIn.jsp"/>
</c:if>