package org.aacp.billing.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Product {
	@Id @Column(length=9)
	int number;
	
	@Column(length=50) @Required
	String description;
	
	@ManyToOne
	(fetch=FetchType.LAZY,
	optional=true)
	@DescriptionsList
	Category category;
	
	@Money
	BigDecimal precio;
	
	@Files
	@Column(length=32)
	String photos;
	
	@TextArea
	String observations;
}