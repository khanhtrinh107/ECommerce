<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class = "text-center" >DANG KY</h2>
<c:url value = "/register" var = "action"  />
<c:if test="${errorMsg != null }">
	<div class = "alert alert-danger" >
		Co Loi Xay Ra
	</div>
</c:if>
<form:form action = "${action}" method ="POST" modelAttribute="user">
	<div class = "form-group" >
		<label for= "username" >Username</label>
		<form:input type = "text" id = "username" path = "username" class = "form-control" />
		<form:errors path = "username" cssClass = "alert" element="div" ></form:errors>
	</div>
	<div class = "form-group" >
		<label for= "password" >password</label>
		<form:input type = "password" id = "password" path = "password" class = "form-control" />
		<form:errors path="password" cssClass = "alert" element="div" ></form:errors>
	</div>
	<div class = "form-group" >
		<label for= "ConfirmPassword" >Confirm password</label>
		<form:input type = "password" id = "ConfirmPassword" path = "confirmPassword" class = "form-control" />
	</div>
	<div class = "form-group" >
		<label for= "firstName" >firstName</label>
		<form:input type = "text" id = "firstName" path = "firstName" class = "form-control" />
	</div>
	<div class = "form-group" >
		<label for= "lastName" >lastName</label>
		<form:input type = "text" id = "lastName" path = "lastName" class = "form-control" />
	</div>
	<div class = "form-group" >
		<label for= "email" >Email</label>
		<form:input type = "text" id = "email" path = "email" class = "form-control" />
	</div>
	<div class = "form-group" >
		<label for= "phone" >Phone</label>
		<form:input type = "text" id = "phone" path = "phone" class = "form-control" />
	</div>
	<div class= "form-group">
		<input type = "submit" value = "Dang ky" />
	</div>
</form:form>