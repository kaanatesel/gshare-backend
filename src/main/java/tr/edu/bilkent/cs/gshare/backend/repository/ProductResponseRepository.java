package tr.edu.bilkent.cs.gshare.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tr.edu.bilkent.cs.gshare.backend.domain.ProductResponse;

public interface ProductResponseRepository extends CrudRepository<ProductResponse, Integer>
{

	List<ProductResponse> findByOwnerId( Integer ownerId );

	List<ProductResponse> findByLenderId( Integer lenderId );
}
