package org.aacp.billing.modelo;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import lombok.*;

public class CalculateNextNumberForYear 
	implements ICalculator{
		
		@Getter @Setter
		int year;
		
		@Override
		public Object calculate() throws Exception {
			Query query = XPersistence.getManager()
					.createQuery("select max(b.number)from Bill b where b.year = :year");
			query.setParameter("year", year);
			Integer lastNumber = (Integer) query.getSingleResult();
			return lastNumber == null ? 1 : lastNumber + 1;
		}
	}