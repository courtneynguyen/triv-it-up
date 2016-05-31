<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*, edu.neumont.pro280.models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/Header.jsp" />
<body>
 <jsp:include page="/WEB-INF/jsp/Navigation.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-12 pull-right"><div class="progress progress-striped">
  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${index/game.rounds.size()*100}" aria-valuemin="${1/game.rounds.size()*100}" aria-valuemax="100" style="width: ${index/game.rounds.size()*100}%;">
   <fmt:formatNumber type="percent" maxIntegerDigits="3" maxFractionDigits="0" value="${index/game.rounds.size()}"/>
  </div>
</div></div>
			
			<div class="col-md-12 white-bg rnd-lg-crner">
			<h3 class="marg-left">Q#${index}: ${round.question.question}</h3>

			<form method="POST" action="${pageURL}">
				<ol>
					<c:forEach begin="0" end="${amountQ}" varStatus="loop" var="answer"
						items="${round.question.answers}">
						<li class="sm-padd"><input class="btn butt-${loop.index}" id="answer${loop.index}" type="radio"
							name="group1" value="${answer.id}" /><label
							for="answer${loop.index}">${answer.answer}</label></li>
					</c:forEach>
				</ol>
				<input type="submit" value="SUBMIT" class="btn btn-success marg-left" />
			</form>
		</div>
	</div>
</body>
</html>