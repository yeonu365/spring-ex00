<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<div class="container">
	
	<%-- spring security test --%>
	
<div>
<%-- 로그인 되어있을 때 principal =>> CustomUser --%>
	<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="pinfo"/><br>
	${pinfo.member.userid } <br>
	${pinfo.member.userpw } <br>
	${pinfo.member.userName } <br>
	</sec:authorize>
	
<%-- 로그아웃 되어있을 때 principal =>> String --%>
	<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="pinfo"/><br>
	${pinfo } <br>
	</sec:authorize>	
	
</div>
	
</div>
</body>
</html>