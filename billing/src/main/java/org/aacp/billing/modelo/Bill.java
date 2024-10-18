package org.aacp.billing.modelo;

import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import lombok.*;

@Entity @Getter @Setter
public class Bill {
	@Id
	@GeneratedValue(generator="system-uuid")@Hidden
	@GenericGenerator(name="system-uuid", strategy= "uuid")
	@Column(length = 32)
	String oid;
	
	@DefaultValueCalculator(CurrentYearCalculator.class)
	@Column(length = 4)
	int year;
	
	@Column(length = 5)
	@DefaultValueCalculator(value = CalculateNextNumberForYear.class,
	properties = @PropertyValue(name="year"))
	int number;
	
	@Required
	@DefaultValueCalculator(CurrentLocalDateCalculator.class)
	LocalDate date;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	Client client;
	
	@ElementCollection
	@ListProperties("product.number, product.description,quantity")
	Collection<Detail> details;
	
	@Stereotype("MEMO")
	String observations;
	
	
}