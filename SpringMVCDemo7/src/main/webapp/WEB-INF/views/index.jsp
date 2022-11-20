<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h1 class="text-center">DANH MUC SAN PHAM</h1>
<form action="">
	<div class="row">
		<div class="col-md-11">
			<input class="form-control" type="text" name="kw" value="${search}">
		</div>
		<div class="col-md-1">
			<input type="submit" value="Search" class="btn">
		</div>
	</div>
</form>
<div class="row">
	<c:forEach var="p" items="${products}">
		<div class="card col-md-4">
			<a href="<c:url value = "/product/${p.id }" />">
				<div class="card-body">
					<c:if test="${p.image == null}">
						<img class="img-fluid" alt="SanPham"
							src="<c:url value = "/images/x.jpg" />">
					</c:if>
					<c:if test="${p.image != null }">
						<img class="img-fluid" alt="SanPham" src="${p.image}">
					</c:if>
				</div>
			</a>
			<div class="card-footer">
				<h3>${p.name}</h3>
				<p>${p.price}VND</p>
			</div>
			<div class="card-footer">
				<a href="javascript:;" class="btn btn-danger"
					onclick="addToCart(${p.id})">Them Vao Gio</a> <a href="#"
					class="btn btn-danger">Mua Ngay</a>
			</div>
		</div>
	</c:forEach>
</div>

