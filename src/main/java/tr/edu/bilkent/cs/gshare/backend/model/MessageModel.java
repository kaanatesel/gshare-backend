package tr.edu.bilkent.cs.gshare.backend.model;

import java.time.Instant;

import lombok.Data;

@Data
public class MessageModel
{
	private Integer id;

	private Integer productRequestId;

	private Instant createTime;

	private Integer senderMemberId;

	private Integer receiverMemberId;

	private String message;

}
