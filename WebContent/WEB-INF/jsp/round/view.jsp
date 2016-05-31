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

<h1>Welcome,  ${user.username}! Let's play TRIV-IT-UP! </h1>

</div>
</div>
</div>

</body>
</html>