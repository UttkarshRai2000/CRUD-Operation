package product.Package.working;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.Package.bin.Product_Base;
import product.Package.repos.Product_Repository;

@Service
//It autodetect the classes when classpath scanning is used
public class ProductImpl implements ProductWork {
	
	@Autowired
	//This will connect my Product_Repository by the help of Autowired
	private Product_Repository product_repo;
	
	@Override
	public String upsert(Product_Base product) {
		product_repo.save(product);
		return "Success";
	}

	@Override
	public Product_Base getById(Integer id) {
		//Optional method help to avoid null point exception
		Optional<Product_Base> findById = product_repo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Product_Base> getAllProduct_Base() {
		return product_repo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if(product_repo.existsById(id)) {
			product_repo.deleteById(id);
			return "record found";
		}else {
			return "No record found";
		}
	}

}
