package tr.edu.bilkent.cs.gshare.backend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema = "public", name = "product_category")
public class ProductCategory
{
	@Id
	private Integer id;

	private String name;

}
