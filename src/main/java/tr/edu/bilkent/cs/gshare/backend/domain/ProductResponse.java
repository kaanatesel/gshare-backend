package tr.edu.bilkent.cs.gshare.backend.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
@Entity
@Table(schema = "public", name = "product_response")
public class ProductResponse
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "product_request_id", updatable = false)
	private Integer productRequestId;

	@Column(name = "create_date", insertable = false, updatable = false)
	@Generated(GenerationTime.ALWAYS)
	private Instant createDate;

	@Column(name = "response_type_id", updatable = false)
	private Integer responseTypeId;

	@NotNull
	private Instant deadline;

	@Column(name = "owner_id", updatable = false)
	private Integer ownerId;

	@Column(name = "lender_id", updatable = false)
	private Integer lenderId;

}
