package tr.edu.bilkent.cs.gshare.backend.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.edu.bilkent.cs.gshare.backend.domain.Member;
import tr.edu.bilkent.cs.gshare.backend.mapper.MemberMapper;
import tr.edu.bilkent.cs.gshare.backend.model.CreateMemberModel;
import tr.edu.bilkent.cs.gshare.backend.model.MemberModel;
import tr.edu.bilkent.cs.gshare.backend.model.UpdateMemberModel;
import tr.edu.bilkent.cs.gshare.backend.repository.MemberRepository;

@Service
public class MemberService
{
	@Autowired
	MemberRepository repository;

	@Autowired
	MemberMapper mapper;

	public MemberModel createMember( CreateMemberModel model )
	{
		Member member = mapper.getMemberFromCreateMemberModel( model );
		repository.save( member );
		MemberModel memberModel = mapper.getMemberModelFromMember( member );
		return memberModel;
	}

	public MemberModel getMember( Integer memberId )
	{
		Member member = repository.findByIdAndActive( memberId, true )
				.orElseThrow( () -> new RuntimeException( "Cannot find member with id " + memberId ) );

		MemberModel memberModel = mapper.getMemberModelFromMember( member );
		return memberModel;
	}

	public MemberModel updateMember( UpdateMemberModel model )
	{
		Member member = repository.findById( model.getId() )
				.orElseThrow( () -> new RuntimeException( "Cannot find member with id " + model.getId() ) );

		mapper.getUpdateMemberFromUpdateMemberModel( member, model );

		repository.save( member );
		MemberModel memberModel = mapper.getMemberModelFromMember( member );
		return memberModel;
	}

	public void deleteMember( Integer memberId )
	{
		Member member = repository.findById( memberId )
				.orElseThrow( () -> new RuntimeException( "Cannot find member with id " + memberId ) );

		member.setActive( false );
		repository.save( member );
	}
}
