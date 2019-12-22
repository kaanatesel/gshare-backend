package tr.edu.bilkent.cs.gshare.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.bilkent.cs.gshare.backend.domain.Message;
import tr.edu.bilkent.cs.gshare.backend.model.CreateMessageModel;
import tr.edu.bilkent.cs.gshare.backend.model.MessageModel;
import tr.edu.bilkent.cs.gshare.backend.service.MessageService;

@RestController
@RequestMapping("message/")
public class MessageController
{
	@Autowired
	MessageService service;

	@PostMapping("create/")
	public MessageModel create( CreateMessageModel model )
	{
		return service.create( model );
	}

	@GetMapping("getMessage/{messageId}")
	public MessageModel findById( @PathVariable(name = "messageId", required = true) Integer messageId )
	{
		return service.findById( messageId );
	}

	@GetMapping("findByProductRequestId/{productRequestId}")
	public List<Message> findByRequestId(
			@PathVariable(name = "productRequestId", required = true) Integer productRequestId )
	{
		return service.findByProductRequestId( productRequestId );
	}

	@DeleteMapping("delete/{messageId}")
	public void delete( @PathVariable(name = "messageId", required = true) Integer messageId )
	{
		service.delete( messageId );
	}

}
