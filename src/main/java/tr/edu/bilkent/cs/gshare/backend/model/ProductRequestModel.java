package tr.edu.bilkent.cs.gshare.backend.model;

import java.time.Instant;

import lombok.Data;

@Data
public class ProductRequestModel
{
	private Integer id;

	private Integer requesterId;

	private Integer productId;

	private Instant createDate;

	private boolean active;

	private Integer ownerId;
}
