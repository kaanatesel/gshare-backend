package tr.edu.bilkent.cs.gshare.backend.repository;

import org.springframework.data.repository.CrudRepository;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer>
{
	void deleteById( Integer id );
}
