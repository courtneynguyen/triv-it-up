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
	 <jsp:include page="/WEB-INF/jsp/NonMemberNav.jsp" />
	
	


<div class="container">
<div class="row platform">
<div class="col-sm-6">
<img class="img-responsive" src='${pageContext.request.contextPath}/images/trivItUpLogo.png' alt="logo" />
</div>
<div class="col-sm-6">
<h1 class="txt-wrapper">Challenge your brain with scientifically designed training</h1>
<form class="" method="POST" action="${pageContext.request.contextPath}/signup">
<div class="input-group"><label for="user" >Username: </label><input id="user" class="form-control"  type="text" name="username" value="BobbyRobit122"/></div>
<div class="input-group"><label for="email" >Email: </label><input id="email" class="form-control" type="email" name="email" value="Bob@jones.com" /></div>
<div class="input-group"><label for="pass" >Password: </label><input id="pass" class="form-control" type="password" name="password" value="bobsagget" /></div>
<div class="input-group butt-group"><input class="butt butt-lg happy-butt" type="submit" value="SUBMIT"/></div>
</form>
</div>


</div>
</div>
<div class="texture">
<div class="container">
<div class="row buffer">
<h3 class="center txt-wrapper">Triv-It-Up is a leader in the science of quizzes and knowledgeable knowledge.</h3>
<div class="col-md-4">
<blockquote>Sincere and Genuine.</blockquote>
</div>
<div class="col-md-4">
<blockquote>Sincere and Genuine.</blockquote>
</div>
<div class="col-md-4">
<blockquote>Sincere and Genuine.</blockquote>
</div>
</div>
</div>
</div>

</body>
</html>