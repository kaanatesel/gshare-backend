package tr.edu.bilkent.cs.gshare.backend.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UpdateMemberModel
{
	@NotNull
	@Min(1)
	private Integer id;

	@NotNull
	@Email
	private String email;

	@NotNull
	@Size(min = 5, max = 100)
	private String password;

	@NotNull
	@Size(min = 5, max = 100)
	private String name;

	private Integer g;
}
