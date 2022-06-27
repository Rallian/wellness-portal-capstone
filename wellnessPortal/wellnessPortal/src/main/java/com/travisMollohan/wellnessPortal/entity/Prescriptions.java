package com.travisMollohan.wellnessPortal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="prescriptions")
@Data
@NoArgsConstructor
public class Prescriptions {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="prescription_name")
	private String name;
	@Column(name="refill_cycle")
	private int refillCycle;
	
	//custom constructor with no id
	public Prescriptions(String name, int refillCycle) {
		super();
		this.name = name;
		this.refillCycle = refillCycle;
	}
	
	
	
}
