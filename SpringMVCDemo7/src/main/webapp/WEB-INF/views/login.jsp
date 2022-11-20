<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/login" var = "action" />
<h2 class = "text-center" >Login</h2>
<c:if test="${param.error != null}">
	<div class = "alert alert-danger">
		Da co loi xay ra
	</div>
</c:if>
<c:if test="${param.accessDenied != null}">
	<div class = "alert alert-danger">
		Ban Khong Co Quyen Truy Cap!
	</div>
</c:if>
<form action = "${action}" method ="POST">
	<div class = "form-group" >
		<label for= "username" >Username</label>
		<input type = "text" id = "username" name = "username" class = "form-control" />
	</div>
	<div class = "form-group" >
		<label for= "password" >Password</label>
		<input type = "password" id = "password" name = "password" class = "form-control" />
	</div>
	<div class= "form-group">
		<input type = "submit" value = "Login" />
	</div>
</form>