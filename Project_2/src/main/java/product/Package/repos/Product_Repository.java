//This interface help to perform operation with database

package product.Package.repos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import product.Package.bin.Product_Base;

//JpaRepository is a extenstion for the Repository. It has full of CRUD operation
public interface Product_Repository extends JpaRepository<Product_Base, Serializable>{

}
