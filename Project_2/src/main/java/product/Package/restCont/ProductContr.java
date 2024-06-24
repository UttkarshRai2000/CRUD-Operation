//It help to deal with working class
package product.Package.restCont;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import product.Package.bin.Product_Base;
import product.Package.working.ProductWork;

@RestController
public class ProductContr {
	
	@Autowired
	//It enables inject the object dependency implicitly
	private ProductWork productWork;
	
	@PostMapping("/ProductPost")
	//used to map HTTP POST request
	//createProduct_Base is a method
	public ResponseEntity<String> createProduct_Base(@RequestBody Product_Base product){
		String status = productWork.upsert(product);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
	@GetMapping("/ProductGet/{id}")
	//used to map HTTP GET request
	//PathVariable to read the data from the url
	public ResponseEntity<Product_Base> getProduct_Base(@PathVariable Integer id){
		Product_Base product = productWork.getById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@GetMapping("/Product")
	//used to map HTTP GET request
	public ResponseEntity<List<Product_Base>> getAllProduct_Base(){
		List<Product_Base> allProduct = productWork.getAllProduct_Base();
		return new ResponseEntity<>(allProduct, HttpStatus.OK);
	}
	@PutMapping("/ProductUpdate")
	//used to map HTTP PUT request
	public ResponseEntity<String> updateProduct_Base(@RequestBody Product_Base product){
		String status = productWork.upsert(product);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	@DeleteMapping("/ProductDelete/{id}")
	//used to map HTTP DELETE request
	public ResponseEntity<String> deleteProduct_Base(@PathVariable Integer id){
		String status = productWork.deleteById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
}
