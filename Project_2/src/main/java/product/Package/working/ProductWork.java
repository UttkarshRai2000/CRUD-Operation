package product.Package.working;

import java.util.List;

import product.Package.bin.Product_Base;

public interface ProductWork {
	
	public String upsert(Product_Base product);
	public Product_Base getById(Integer id);
	public List<Product_Base> getAllProduct_Base();
	public String deleteById(Integer id);
}
