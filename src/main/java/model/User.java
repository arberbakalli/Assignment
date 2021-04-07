package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
	String website;
	Address address;
	String phone;
	String name;
	Company company;
	int id;
	String email;
	String username;
}