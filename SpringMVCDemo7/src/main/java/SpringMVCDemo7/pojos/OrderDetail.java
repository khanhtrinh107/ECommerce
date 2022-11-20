package SpringMVCDemo7.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "unit_price")
	private float price;
	@Column(name = "num")
	private int num;
	@JoinColumn(name = "product_id",referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Product product;
	@JoinColumn(name = "order_id" , referencedColumnName = "id")
	@ManyToOne
	private SaleOrder orderId;
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public SaleOrder getOrderId() {
		return orderId;
	}
	public void setOrderId(SaleOrder orderId) {
		this.orderId = orderId;
	}
	
	
}
