package tr.edu.bilkent.cs.gshare.backend.model;

import java.time.Instant;

import lombok.Data;

@Data
public class ProductResponseModel
{
	private Integer id;

	private Integer productRequestId;

	private Instant createDate;

	private Integer responseTypeId;

	private Instant deadline;

	private Integer ownerId;

	private Integer lenderId;
}
