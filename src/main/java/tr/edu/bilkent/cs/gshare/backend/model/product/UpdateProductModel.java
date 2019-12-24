package tr.edu.bilkent.cs.gshare.backend.model.product;

import lombok.Data;

@Data
public class UpdateProductModel
{

	private int id;

	private int productCategory;

	private String name;

	private String description;

	private int price;

	private Boolean active;
}
