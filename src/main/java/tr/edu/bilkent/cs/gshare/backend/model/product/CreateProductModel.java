package tr.edu.bilkent.cs.gshare.backend.model.product;

import lombok.Data;
import tr.edu.bilkent.cs.gshare.backend.domain.ProductCategory;

@Data
public class CreateProductModel
{
	private int productCategory;

	private int memberId;

	private String name;

	private String description;

	private int price;

}
