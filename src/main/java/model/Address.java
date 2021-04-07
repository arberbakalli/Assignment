package model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address{
	String zipcode;
	Geo geo;
	String suite;
	String city;
	String street;
}
