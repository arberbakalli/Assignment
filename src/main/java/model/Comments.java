package model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comments {
	private String name;
	private int postId;
	private int id;
	private String body;
	private String email;
}
