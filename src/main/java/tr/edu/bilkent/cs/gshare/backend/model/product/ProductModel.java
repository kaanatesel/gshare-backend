package tr.edu.bilkent.cs.gshare.backend.model.product;

import lombok.Data;

@Data
public class ProductModel
{
	private int id;

	private int productCategory;

	private int memberId;
	
	private String name;

	private String description;

	private int price;

}
