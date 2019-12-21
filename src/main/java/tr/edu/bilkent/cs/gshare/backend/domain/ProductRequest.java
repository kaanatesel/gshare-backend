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

import lombok.Builder.Default;
import lombok.Data;

@Data
@Entity
@Table(schema = "public", name = "product_request")
public class ProductRequest
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "requester_id", updatable = false)
	private int requesterId;

	@Column(name = "product_id", updatable = false)
	private int productId;

	@Column(name = "create_date", insertable = false, updatable = false)
	@Generated(GenerationTime.ALWAYS)
	private Instant createDate;

	@Column(name = "active", insertable = false, nullable = false)
	@Generated(GenerationTime.INSERT)
	private boolean active;

}
