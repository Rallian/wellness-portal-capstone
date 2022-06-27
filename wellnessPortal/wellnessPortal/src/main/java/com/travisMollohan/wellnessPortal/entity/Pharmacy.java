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
@Table(name="pharmacy")
public class Pharmacy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column(name="pharmacy_name")
	private String name;
	@Column(name="pharmacy_address")
	private String address;
	
	
	
	
	
	
	
	
	// custom constructor without Id
	public Pharmacy(String name, String address) {
	this.name = name;
	this.address = address;
	
}
	
	
	
	
	
	
}
