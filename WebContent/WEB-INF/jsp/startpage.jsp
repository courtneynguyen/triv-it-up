<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*, edu.neumont.pro280.models.*, edu.neumont.pro280.managers.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<jsp:include page="/WEB-INF/jsp/Header.jsp" />
	<body>
	<!-- test -->
		<jsp:include page="/WEB-INF/jsp/Navigation.jsp" />
		<div class="container">
			<div class="row platform">
				<h1>Welcome, ${user.getUsername()}!</h1>
				
				<!--  <a href="${pageContext.request.contextPath}/game/${game.gameName}/round/1">Single Player</a> -->
				<form method="POST" action="${pageContext.request.contextPath}/game/create">
				<input class="butt happy-butt pull-left" type="submit" name="gamemode" value="Single Player"> <input class="butt happy-butt" type="submit" name="gamemode" value="Multi Player">
					<h2 class="category">What category of trivia would you like?</h2>
					<div class="texture sm-buffer rnd-lg-crner txt-50-padd">
					<c:forEach var="categories" items="${categoriesList}">
						<input type="radio" name="category" value="${categories.id}"> ${categories.category} <br/>
					</c:forEach>
					</div>
					
				</form>
			</div>
		</div>
	</body>
</html>