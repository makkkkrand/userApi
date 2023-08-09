package com.medSoft.app.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Embeddable
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String country;
	@Column
	private String countryCode;
	@Column
	private String postalCode;

}
