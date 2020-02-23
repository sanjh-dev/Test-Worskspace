package in.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nit.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
