<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, edu.neumont.pro280.models.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/Header.jsp" />
<body>
 <jsp:include page="/WEB-INF/jsp/Navigation.jsp" />
<div class="container">
<div class="row platform">
<div class="col-sm-12 white-bg rnd-lg-crner">
<h2 class="marg-left">Results</h2>
<ol>
<c:forEach varStatus="loop" var="result" items="${results}">
	<c:choose>
	<c:when test="${result.answer.correctAnswer}">
	<li class="sm-padd alert alert-success">
	</c:when>
	<c:otherwise>
	<li class="sm-padd alert alert-danger">
	</c:otherwise>
	</c:choose>
	${result.round.question.question} : You answered: ${ result.answer.answer }
	</li>
</c:forEach>
</ol>
<h1 class="marg-left">You scored: 
${score}
</h1>
<div class="col-sm-4 col-xs-3"></div>
<div class="col-lg-4 col-sm-5 col-xs-6">
<a class="btn btn-success buffer" href="${pageContext.request.contextPath}/game">Play Again?</a>

<a class="btn btn-default buffer" href="">Go to Lobby</a>
<div class="col-sm-4 col-xs-3"></div>
</div>
</div>
</div>
</div>

</body>
</html>