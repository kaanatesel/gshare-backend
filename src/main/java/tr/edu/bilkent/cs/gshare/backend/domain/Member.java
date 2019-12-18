package tr.edu.bilkent.cs.gshare.backend.domain;

import java.io.Serializable;
import java.time.Instant;
import java.time.OffsetDateTime;

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
@Table(schema = "public", name = "member")
public class Member implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String email;

	private String password;

	private String name;

	@Column(name = "create_date", insertable = false, updatable = false)
	@Generated(GenerationTime.ALWAYS)
	private Instant createDate;

	@Column(name = "active", insertable = false, nullable = false)
	@Generated(GenerationTime.INSERT)
	private Boolean active;
}
