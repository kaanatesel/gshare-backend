package tr.edu.bilkent.cs.gshare.backend.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateProductRequestModel
{
	@NotNull
	private int requesterId;
	@NotNull
	private int productId;
}
