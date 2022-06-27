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
@Data
@NoArgsConstructor
@Table(name="insurance")
public class Insurance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column(name="plan_name")
	private String planName;
	@Column(name="monthly_cost")
	private Double monthlyCost;
	@Column
	private Double deductible;

	
	//custom constructor without id
	public Insurance(String planName, Double monthlyCost, 
			Double deductible) {
		this.planName = planName;
		this.monthlyCost = monthlyCost;
		this.deductible = deductible;
		
	}
	
	
}
