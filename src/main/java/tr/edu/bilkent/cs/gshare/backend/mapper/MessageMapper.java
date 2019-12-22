package tr.edu.bilkent.cs.gshare.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tr.edu.bilkent.cs.gshare.backend.domain.Message;
import tr.edu.bilkent.cs.gshare.backend.model.CreateMessageModel;
import tr.edu.bilkent.cs.gshare.backend.model.MessageModel;

@Mapper
public abstract class MessageMapper
{

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createTime", ignore = true)
	public abstract Message getMessageFromCreateMessageModel( CreateMessageModel model );

	public abstract MessageModel getMessageModelFromMessage( Message message );

}
