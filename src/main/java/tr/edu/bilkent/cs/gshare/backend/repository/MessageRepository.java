package tr.edu.bilkent.cs.gshare.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tr.edu.bilkent.cs.gshare.backend.domain.Message;

public interface MessageRepository extends CrudRepository<Message, Integer>
{
	List<Message> findByProductRequestId( Integer productRequestId );
}
