    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar navbar-default trans-gradient" role="navigation">
      <div class="container">
      <div class="row">
<div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">
            <img class="logo" src="/images/trivItUpLogo.png" alt="logo"></a>
          </div>
          <div class="navbar-collapse collapse row">
            <ul class="nav navbar-nav pull-right">
               <li><a class="butt happy-butt butt-space" href="${pageContext.request.contextPath}/game">Profile</a></li>
              <li><a class="butt sad-butt butt-space" href="${pageContext.request.contextPath}/logout">Log Out</a></li>
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