<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="text-center text-danger">Gio Hang</h1>
<c:if test="${cart == null}">
	<h4 class = "text-center text-danger">Ban Chua Co Gi Trong Gio Hang</h4>
</c:if>
<c:if test="${cart != null}">
	<table class="table">
		<tr id = "${c.productId}">
			<th>Ma San Pham</th>
			<th>Ten San Pham</th>
			<th>Don Gia</th>
			<th>So Luong</th>
		</tr>
		<c:forEach var="c" items="${carts}">
			<tr id = "${c.productId}">
				<td>${c.productId}</td>
				<td>${c.name}</td>
				<td>${c.price}VND</td>
				<td><input type="number" onblur = "updateCart(this,${c.productId})" value="${c.count}" /></td>
				<td><input class="btn btn-danger"  type="button" value="Delete" onclick="deleteCart(${c.productId})" /></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<div>
	<h4>Tong: <span id = "amount">${cartState.amount}</span>VND</h4>
</div>
<a href="pay"  class="btn btn-danger" >Thanh Toan</a>
<br>
<br>