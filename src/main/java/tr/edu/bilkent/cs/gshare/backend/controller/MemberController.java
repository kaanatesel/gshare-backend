package tr.edu.bilkent.cs.gshare.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.bilkent.cs.gshare.backend.model.CreateMemberModel;
import tr.edu.bilkent.cs.gshare.backend.model.MemberModel;
import tr.edu.bilkent.cs.gshare.backend.model.UpdateMemberGModel;
import tr.edu.bilkent.cs.gshare.backend.model.UpdateMemberModel;
import tr.edu.bilkent.cs.gshare.backend.service.MemberService;

@RestController
@RequestMapping("member/")
public class MemberController
{
	@Autowired
	MemberService service;

	@PostMapping(value = "create")
	public MemberModel createMember( CreateMemberModel model )
	{
		return service.createMember( model );
	}

	@PostMapping(value = "update")
	public MemberModel updateMember( UpdateMemberModel model )
	{
		return service.updateMember( model );
	}

	@GetMapping(value = "{memberId}/")
	public MemberModel getMember( @PathVariable(value = "memberId", required = true) Integer memberId )
	{
		return service.getMember( memberId );
	}

	@DeleteMapping(value = "{memberId}/")
	public void deleteMember( @PathVariable(value = "memberId", required = true) Integer memberId )
	{
		service.deleteMember( memberId );
	}

	@PutMapping("updatememberg/")
	public MemberModel updateMemberG( UpdateMemberGModel model )
	{
		return service.updateMemberG( model );
	}

	@GetMapping("getByEmail/{email}")
	public MemberModel getByEmail( @PathVariable(value = "email", required = true) String email )
	{
		return service.findByEmail( email );
	}
}
