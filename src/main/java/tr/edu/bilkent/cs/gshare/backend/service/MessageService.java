package tr.edu.bilkent.cs.gshare.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.edu.bilkent.cs.gshare.backend.domain.Message;
import tr.edu.bilkent.cs.gshare.backend.mapper.MessageMapper;
import tr.edu.bilkent.cs.gshare.backend.model.CreateMessageModel;
import tr.edu.bilkent.cs.gshare.backend.model.MessageModel;
import tr.edu.bilkent.cs.gshare.backend.repository.MessageRepository;

@Service
public class MessageService
{
	@Autowired
	MessageMapper mapper;

	@Autowired
	MessageRepository repository;

	public MessageModel create( CreateMessageModel model )
	{
		Message message = mapper.getMessageFromCreateMessageModel( model );
		repository.save( message );
		MessageModel msgModel = mapper.getMessageModelFromMessage( message );
		return msgModel;
	}

	public MessageModel findById( Integer messageId )
	{
		Message msg = repository.findById( messageId )
				.orElseThrow( () -> new RuntimeException( "Cannot find message with id " + messageId ) );

		MessageModel messageModel = mapper.getMessageModelFromMessage( msg );
		return messageModel;
	}

	public List<Message> findByProductRequestId( Integer productRequestId )
	{
		List<Message> listMessage = repository.findByProductRequestId( productRequestId );
		return listMessage;
	}

	public void delete( Integer messageId )
	{
		repository.deleteById( messageId );
	}

}
