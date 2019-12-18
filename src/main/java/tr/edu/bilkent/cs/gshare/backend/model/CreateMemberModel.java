package tr.edu.bilkent.cs.gshare.backend.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CreateMemberModel
{
	@NotNull
	@Email
	private String email;

	@NotNull
	@Size(min = 5, max = 100)
	private String password;

	@NotNull
	@Size(min = 5, max = 100)
	private String name;
}
