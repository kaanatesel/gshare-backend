package tr.edu.bilkent.cs.gshare.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tr.edu.bilkent.cs.gshare.backend.domain.Demand;

public interface DemandRepository extends CrudRepository<Demand, Integer>
{
	Optional<Demand> findByIdAndActive( Integer requesterId, boolean active );

	List<Demand> findAllByCategoryId( Integer categoryId );

	List<Demand> findAllByRequesterId( Integer requesterId );

}
