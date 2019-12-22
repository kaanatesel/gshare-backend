package tr.edu.bilkent.cs.gshare.backend.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateProductRequestModel
{
	@NotNull
	private Integer requesterId;
	@NotNull
	private Integer productId;
	@NotNull
	private Integer ownerId;
}
