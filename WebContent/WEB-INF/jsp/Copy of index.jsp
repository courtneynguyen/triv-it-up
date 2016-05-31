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
	<div class="col-sm-6">
	<h2>Sign Up Here</h2>
	<form class="" method="POST" action="${pageContext.request.contextPath}/signup">
	<div class="input-group"><label for="user" >Username: </label><input id="user" class="form-control"  type="text" name="username" value="BobbyRobit122"/></div>
	<div class="input-group"><label for="email" >Email: </label><input id="email" class="form-control" type="email" name="email" value="Bob@jones.com" /></div>
	<div class="input-group"><label for="pass" >Password: </label><input id="pass" class="form-control" type="password" name="password" value="bobsagget" /></div>
	<div class="input-group"><input class="btn btn-success" type="submit" value="SUBMIT"/></div>
	</form>
	</div>
	
	<div class="col-sm-6">
	<h2>Login Here</h2>
	<form class="" method="POST" action="${pageContext.request.contextPath}/login">
	<div class="input-group"><label for="user" >Username: </label><input id="user" class="form-control"  type="text" name="username" value="BobbyRobit122"/></div>
	<div class="input-group"><label for="pass" >Password: </label><input id="pass" class="form-control" type="password" name="password" value="bobsagget" /></div>
	<div class="input-group"><input class="btn btn-success" type="submit" value="SUBMIT"/></div>
	</form>
	</div>
	</div>
	</div>

</body>
</html>