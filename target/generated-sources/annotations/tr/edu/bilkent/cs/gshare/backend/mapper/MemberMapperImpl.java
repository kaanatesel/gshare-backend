package tr.edu.bilkent.cs.gshare.backend.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tr.edu.bilkent.cs.gshare.backend.domain.Member;
import tr.edu.bilkent.cs.gshare.backend.model.CreateMemberModel;
import tr.edu.bilkent.cs.gshare.backend.model.MemberModel;
import tr.edu.bilkent.cs.gshare.backend.model.UpdateMemberModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-21T17:03:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl extends MemberMapper {

    @Override
    public Member getMemberFromCreateMemberModel(CreateMemberModel model) {
        if ( model == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( model.getEmail() );
        member.setPassword( model.getPassword() );
        member.setName( model.getName() );

        return member;
    }

    @Override
    public MemberModel getMemberModelFromMember(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberModel memberModel = new MemberModel();

        memberModel.setId( member.getId() );
        memberModel.setEmail( member.getEmail() );
        memberModel.setPassword( member.getPassword() );
        memberModel.setName( member.getName() );
        memberModel.setCreateDate( member.getCreateDate() );

        return memberModel;
    }

    @Override
    public void getUpdateMemberFromUpdateMemberModel(Member member, UpdateMemberModel model) {
        if ( model == null ) {
            return;
        }

        member.setEmail( model.getEmail() );
        member.setPassword( model.getPassword() );
        member.setName( model.getName() );
    }
}
