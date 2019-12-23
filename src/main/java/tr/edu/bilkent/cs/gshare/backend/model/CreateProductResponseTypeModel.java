package tr.edu.bilkent.cs.gshare.backend.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateProductResponseTypeModel
{
	@NotNull
	private Integer id;

	@NotNull
	private String name;
}
