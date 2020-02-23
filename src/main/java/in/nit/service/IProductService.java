package in.nit.service;

import java.util.List;
import java.util.Optional;

import in.nit.model.Product;

public interface IProductService {
	List<Product>getAllProducts();
	public void deleteProduct(Integer id);
	Optional<Product>getOneProduct(Integer id);
	Integer saveProduct(Product p);

}
