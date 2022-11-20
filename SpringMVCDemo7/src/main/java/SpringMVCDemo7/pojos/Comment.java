package SpringMVCDemo7.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
	@JoinColumn(name = "product_id",referencedColumnName = "id")
	@ManyToOne(optional = false)
	@JsonIgnore
	private Product product;
	@JoinColumn(name = "user_id" , referencedColumnName = "id")
	@ManyToOne(optional = false)
	@JsonIgnore
	private User user;
	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public Comment(int id, String content, Product product, User user, Date createdDate) {
		super();
		this.id = id;
		this.content = content;
		this.product = product;
		this.user = user;
		this.createdDate = createdDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
