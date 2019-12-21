package tr.edu.bilkent.cs.gshare.backend.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import tr.edu.bilkent.cs.gshare.backend.domain.Member;
import tr.edu.bilkent.cs.gshare.backend.model.CreateMemberModel;
import tr.edu.bilkent.cs.gshare.backend.model.MemberModel;
import tr.edu.bilkent.cs.gshare.backend.model.UpdateMemberModel;

@Mapper
public abstract class MemberMapper
{

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createDate", ignore = true)
	@Mapping(target = "active", ignore = true)
	public abstract Member getMemberFromCreateMemberModel( CreateMemberModel model );

	public abstract MemberModel getMemberModelFromMember( Member member );

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createDate", ignore = true)
	@Mapping(target = "active", ignore = true)
	public abstract void getUpdateMemberFromUpdateMemberModel( @MappingTarget Member member, UpdateMemberModel model );

}
