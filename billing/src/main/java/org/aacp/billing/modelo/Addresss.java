package org.aacp.billing.modelo;

import javax.persistence.*;

import lombok.*;

@Embeddable @Getter @Setter
public class Addresss {
	@Column(length=30)
	String publicStreet;
	
	@Column(length=5)
	int postalCode;
	
	@Column(length=20)
	String city;
	
	@Column(length=30)
	String state;
}