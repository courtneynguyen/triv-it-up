    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar navbar-default" role="navigation">
      <div class="container">
      <div class="row">
<div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}">Triv It Up</a>
          </div>
          <div class="navbar-collapse collapse row">
            <ul class="nav navbar-nav pull-right">
               <li><form class="horiz-form" method="POST" action="${pageContext.request.contextPath}/login">
<div class="input-group"><label for="user" >Username: </label><input id="user" class="form-control"  type="text" name="username" value="BobbyRobit122"/></div>
<div class="input-group"><label for="pass" >Password: </label><input id="pass" class="form-control" type="password" name="password" value="bobsagget" /></div>
<div class="input-group butt-group"><input class="butt happy-butt" type="submit" value="SUBMIT"/></div>
</form></li>
            </ul>
            <div class="pull-right">
            <c:if test="${sessionScope.userId == ''}">
            <a href="/">${sessionScope.userId} Logout</a>
            </c:if>
            </div>
      </div>
      </div>
      </div>
      </div>