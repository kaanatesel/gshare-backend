package tr.edu.bilkent.cs.gshare.backend.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UpdateDemandModel
{
	@Id
	private Integer id;

	@NotNull
	private String productDescription;

	@NotNull
	@Size(min = 0)
	private Integer minPrice;

	@NotNull
	@Size(min = 0)
	private Integer maxPrice;

	private Integer categoryId;

}
