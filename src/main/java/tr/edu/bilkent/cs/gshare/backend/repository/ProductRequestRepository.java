package tr.edu.bilkent.cs.gshare.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductRequest;

public interface ProductRequestRepository extends CrudRepository<ProductRequest, Integer>
{
	List<ProductRequest> findByRequesterId( Integer requesterId );
}
