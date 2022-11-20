package SpringMVCDemo7.pojos;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "product")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 5,max = 100, message = "Ten san pham toi thieu la 5 , toi da la 100")
	private String name;
	private String description;
	@Min(value = 10000, message = "Gia toi thieu la 10000")
	@Max(value = 10000000 , message = "Gia toi da la 10000000")
	private double price;
	private String image;
	private int active;
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product",fetch = FetchType.EAGER)
	private Collection<Comment> commentCollections; 
	@ManyToMany
	@JoinTable(
			name = "pro_man",
			joinColumns = {@JoinColumn(name = "product_id")},
			inverseJoinColumns = {@JoinColumn(name = "manufacturer_id")}
	)
	@JsonIgnore
	private List<Manufacturer> manufacturers;
	public Collection<Comment> getCommentCollections() {
		return commentCollections;
	}
	public void setCommentCollections(Collection<Comment> commentCollections) {
		this.commentCollections = commentCollections;
	}
	@Transient
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public List<Manufacturer> getManufacturers() {
		return manufacturers;
	}
	public void setManufacturers(List<Manufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", manufacturers=" + manufacturers + "]";
	}
	
	
}
