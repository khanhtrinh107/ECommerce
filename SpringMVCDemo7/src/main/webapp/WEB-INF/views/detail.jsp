<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="text-center">Chi Tiet San Pham</h2>

<div class="row">
	<div class="col-md-6">
		<c:if test="${product.image == null}">
			<img class="img-fluid" alt="SanPham"
				src="<c:url value = "/images/x.jpg" />">
		</c:if>
		<c:if test="${product.image != null }">
			<img class="img-fluid" alt="SanPham" src="${product.image}">
		</c:if>
	</div>
	<div class="col-md-6">
		<h1>${product.name}</h1>
		<h3 class="text-danger">${product.price }</h3>
		<p>${product.description}</p>
		<input type="button" value="Dat Hang" class="btn btn-danger" />
	</div>
</div>
<br>
<br>
<form>
	<div class="form-group">
		<textarea class="form-control" id="comment"
			placeholder="Nhap Danh Gia Cua Ban"></textarea>
		<br>
		<br> <input type="submit" value="Gui Binh Luan"
			onclick="addComment(${product.id})" class="btn btn-danger" />
	</div>
</form>
<br>
<br>
<div id="commentArea">
	<c:forEach items="${product.commentCollections}" var="comment">
		<div class="row">
			<div class="col-md-2">
				<img alt="" class="rounded-circle img-fluid"
					src="<c:url value = "/images/x.jpg" />">
			</div>
			<div class="col-md-10">
				<p>${comment.content}</p>
				<i>${comment.createdDate}</i>
			</div>
		</div>
	</c:forEach>
</div>
