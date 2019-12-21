package tr.edu.bilkent.cs.gshare.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import tr.edu.bilkent.cs.gshare.backend.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>
{
	public List<Product> findByMemberId( int memberId );
}
