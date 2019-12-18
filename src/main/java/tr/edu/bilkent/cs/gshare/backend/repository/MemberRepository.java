package tr.edu.bilkent.cs.gshare.backend.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tr.edu.bilkent.cs.gshare.backend.domain.Member;

public interface MemberRepository extends CrudRepository<Member, Integer>
{

	Optional<Member> findByIdAndActive( Integer memberId, boolean active );

}
