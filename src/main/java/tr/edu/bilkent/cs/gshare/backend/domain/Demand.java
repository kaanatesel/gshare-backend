package tr.edu.bilkent.cs.gshare.backend.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import lombok.Data;

@Data
@Entity
@Table(schema = "public", name = "product_demand")
public class Demand
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "requester_id")
	private Integer requesterId;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "min_price")
	private Integer minPrice;

	@Column(name = "max_price")
	private Integer maxPrice;

	@Column(name = "create_date", insertable = false, updatable = false)
	private Instant createDate;

	@Column(name = "active", insertable = false, nullable = false)
	@Generated(GenerationTime.INSERT)
	private Boolean active;

	@Column(name = "category_id", nullable = false)
	private Integer categoryId;

}
