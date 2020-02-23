package in.nit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.model.Product;
import in.nit.repository.ProductRepository;
import in.nit.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = repo.findAll();
		return list;
	}

	@Override
	public void deleteProduct(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public Optional<Product> getOneProduct(Integer id) {
		return repo.findById(id);

	}

	@Override
	public Integer saveProduct(Product p) {
		Double gst = p.getGst();
		Double discount = p.getDiscount();
		p.setGst(gst);
		p.setDiscount(discount);
		Integer id = repo.save(p).getProdId();
		return id;

	}

}
