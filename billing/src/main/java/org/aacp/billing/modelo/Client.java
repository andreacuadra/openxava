package org.aacp.billing.modelo;


import javax.persistence.*;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Client {
	@Id
	@Column(length=5)
	int number;
	
	@Column(length=50)
	@Required
	String name;
	
	@Embedded @NoFrame
	Addresss address;
}
