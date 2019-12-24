package tr.edu.bilkent.cs.gshare.backend.model;

import java.time.Instant;

import lombok.Data;

@Data
public class CreateProductResponseModel
{
	private Integer productRequestId;

	private Integer responseTypeId;

	private Instant deadline;

	private Integer ownerId;

	private Integer lenderId;
}
