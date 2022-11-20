<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="<c:url value = "/" />">Trang Chu</a>
    </li>
    <c:forEach items="${categories}" var="cat">
    	<li class="nav-item">
	      <a class="nav-link" href="#">${cat.getName()}</a>
	    </li>
    </c:forEach>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
    	<li class="nav-item">
	      <a class="nav-link" href='<c:url value = "/login"  />'>Login</a>
	 	</li>
		 <li class="nav-item">
		      <a class="nav-link" href='<c:url value = "/register"  />'>Dang Ky</a>
		 </li>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
    	<li class="nav-item">
	      <a class="nav-link" href='<c:url value = "/"  />'>${pageContext.request.userPrincipal.name}</a>
	 	</li>
	 	<li class="nav-item">
		      <a class="nav-link" href='<c:url value = "/logout"  />'>Dang Xuat</a>
		 </li>
    </c:if>
    <li class="nav-item">
		      <a class="nav-link" href='<c:url value = "/cart"  />'>Gio Hang <span id = "cart-counter" class = "badge badge-danger" >${count }</span></a>
		 </li>
  </ul>
</nav>
