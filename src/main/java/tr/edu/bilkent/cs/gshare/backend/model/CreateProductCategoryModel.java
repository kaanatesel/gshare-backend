package tr.edu.bilkent.cs.gshare.backend.model;

import java.util.Set;

import lombok.Data;
import tr.edu.bilkent.cs.gshare.backend.domain.Product;

@Data
public class CreateProductCategoryModel
{
	private int id;
	private String name;
}
