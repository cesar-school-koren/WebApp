<%@ tag language="java" pageEncoding="ISO-8859-1" body-content="scriptless"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!-- Se o usuario for anonimo redireciona para o home -->
<c:if test="${sessionScope.conta == null}">
	<c:redirect url= "home.jsp"/>
</c:if>