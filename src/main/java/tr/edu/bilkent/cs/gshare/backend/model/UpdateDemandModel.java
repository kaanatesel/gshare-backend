package tr.edu.bilkent.cs.gshare.backend.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateDemandModel
{
	@Id
	private Integer id;

	@NotNull
	private String productDescription;

	private Integer categoryId;

}
