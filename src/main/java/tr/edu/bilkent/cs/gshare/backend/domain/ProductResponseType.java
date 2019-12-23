package tr.edu.bilkent.cs.gshare.backend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(schema = "public", name = "product_response_type")
public class ProductResponseType
{
	@Id
	private Integer id;

	@NotNull
	private String name;
}
