package tr.edu.bilkent.cs.gshare.backend.repository;

import org.springframework.data.repository.CrudRepository;

import tr.edu.bilkent.cs.gshare.backend.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>
{

}
