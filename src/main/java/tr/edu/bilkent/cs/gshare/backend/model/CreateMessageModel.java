package tr.edu.bilkent.cs.gshare.backend.model;

import lombok.Data;

@Data
public class CreateMessageModel
{
	private Integer productRequestId;

	private Integer senderMemberId;

	private Integer receiverMemberId;

	private String message;
}
