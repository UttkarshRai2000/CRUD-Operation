//We make this class which uses to represent the Data
package product.Package.bin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
//It is the bundles the feature of Getter/Setter,ToString, Constructor together
@Entity
//It marks the class as a persistent entity that the class should be treated as a table in database
@Table(name = "product_table")
//It provide the specifics of the corresponding database table
public class Product_Base {
	@Override
	public String toString() {
		return "Product_Base [id=" + id + ", name=" + name + ", catogery=" + catogery + ", price=" + price + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatogery() {
		return catogery;
	}
	public void setCatogery(String catogery) {
		this.catogery = catogery;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Product_Base() {
		
	}
	public Product_Base(String name, String catogery, Double price) {
		super();
		this.name = name;
		this.catogery = catogery;
		this.price = price;
	}
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//It specify the strategy used for generating primary key values for entities.
	@Id
	//This will identify as a uniquely entity in the database.
	private Integer id;
	private String name;
	private String catogery;
	private Double price;
}
