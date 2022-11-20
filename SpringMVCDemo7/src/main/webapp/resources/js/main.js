function addToCart(productId) {
	fetch(`http://localhost:8080/SpringMVCDemo7/api/cart/${productId}`).then(res => res.json()).then(data => {
		var d = document.getElementById("cart-counter")
		if (d !== null)
			d.innerText = data
	})
}

function updateCart(obj, productId) {
	fetch("http://localhost:8080/SpringMVCDemo7/api/cart", {
		method: "put",
		body: JSON.stringify({
			"productId": productId,
			"name": "",
			"price": 0,
			"count": obj.value
		}),
		headers: {
			"Content-Type": "application/json"
		}
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		var d = document.getElementById("cart-counter")
		if (d !== null)
			d.innerText = data.count
		var amount = document.getElementById("amount")
		amount.innerText = data.amount
	})
}

function deleteCart(productId) {
	if (confirm("Ban co chac chan xoa san pham khong?") == true) {
		fetch(`http://localhost:8080/SpringMVCDemo7/api/cart/${productId}`, {
			method: "delete"
		}).then(function(res) {
			return res.json()
		}).then(function(data) {
			var d = document.getElementById("cart-counter")
			if (d !== null)
				d.innerText = data.count
			var tmp = document.getElementById(`${productId}`)
			tmp.style.display = "none"
			var amount = document.getElementById("amount")
			amount.innerText = data.amount
		})
	}
}


function addComment(productId) {
	fetch('http://localhost:8080/SpringMVCDemo7/api/add-comment', {
		method: 'POST',
		body: JSON.stringify({
			"content": document.getElementById('comment').value,
			"productId": productId
		}),
		headers: {
			"Content-Type": "application/json"
		}
	}).then(function(res) {
		return res.json()
	}).then(function(data) {
		let cmt = document.getElementById('commentArea')
		cmt.innerHTML += `<div class="row">
			<div class="col-md-2">
				<img alt="" class="rounded-circle img-fluid"
					src="<c:url value = "/images/x.jpg" />">
			</div>
			<div class="col-md-10">
				<p>${data.content}</p>
				<i>${data.createdDate}</i>
			</div>
		</div>
		`
	})
}