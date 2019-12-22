package tr.edu.bilkent.cs.gshare.backend.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(schema = "public", name = "member_message")
public class Message
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(name = "product_request_id")
	private Integer productRequestId;

	@Column(name = "create_date", updatable = false, insertable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Instant createTime;

	@NotNull
	@Min(0)
	@Column(name = "sender_member_id")
	private Integer senderMemberId;

	@NotNull
	@Min(0)
	@Column(name = "receiver_member_id")
	private Integer receiverMemberId;

	@NotNull
	private String message;

}
