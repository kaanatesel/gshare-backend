package tr.edu.bilkent.cs.gshare.backend.model;

import java.time.Instant;

import lombok.Data;

@Data
public class DemandModel
{
	private Integer id;

	private Integer requesterId;

	private String productDescription;

	private Instant createDate;

	private Boolean active;

	private Integer categoryId;
}
