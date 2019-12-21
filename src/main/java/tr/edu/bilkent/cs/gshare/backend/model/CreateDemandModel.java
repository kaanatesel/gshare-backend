package tr.edu.bilkent.cs.gshare.backend.model;

import lombok.Data;

@Data
public class CreateDemandModel
{

	private Integer requesterId;

	private String productDescription;

	private Integer minPrice;

	private Integer maxPrice;

	private Integer categoryId;

}
