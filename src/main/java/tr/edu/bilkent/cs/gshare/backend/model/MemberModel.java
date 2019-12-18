package tr.edu.bilkent.cs.gshare.backend.model;

import java.time.Instant;

import lombok.Data;

@Data
public class MemberModel
{
	private Integer id;

	private String email;

	private String password;

	private String name;

	private Instant createDate;

}
