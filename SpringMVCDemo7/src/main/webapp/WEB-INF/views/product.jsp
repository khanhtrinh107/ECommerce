<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="text-center">Quan ly san pham</h1>
<c:url value="/admin/products" var="action" />
<c:if test="${errMsg != null }">
	<div class = "alert" >${errMsg}</div>
</c:if>
<form:form method="post" action="${action }" modelAttribute="product"
	enctype="multipart/form-data">
	<div class="form-group">
		<label for="name">Ten</label>
		<form:input type="text" id="name" cssClass="form-control" path="name" />
		<form:errors path="name" cssClass="alert" element="div"></form:errors>
	</div>
	<div class="form-group">
		<label for="description">Mo ta</label>
		<form:textarea id="description" cssClass="form-control"
			path="description" />
		<form:errors path="description" cssClass="alert" element="div"></form:errors>
	</div>

	<div class="form-group">
		<label for="price">Gia</label>
		<form:input type="text" id="price" cssClass="form-control"
			path="price" />
		<form:errors path="price" cssClass="alert" element="div"></form:errors>
	</div>

	<div class="form-group">
		<label for="cate">Danh muc</label>
		<form:select id = "cate" path="category" ccsClass = "form-control">
			<c:forEach items="${categories}" var = "cat" >
				<option value = "${cat.id }">${cat.name}</option>
			</c:forEach>
		</form:select>
	</div>

	<div class="form-group" for="file">
		<form:input type="file" id="file" cssClass="form-control" path="file" />
	</div>

	<div class="form-group">
		<input type="submit" value="them san pham" class="btn">
	</div>
</form:form>