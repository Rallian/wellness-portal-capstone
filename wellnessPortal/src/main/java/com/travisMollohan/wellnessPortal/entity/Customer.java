package com.travisMollohan.wellnessPortal.entity;


import java.util.Collection;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer", uniqueConstraints = @UniqueConstraint(columnNames= "email"))
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String email;
	private String password;
	@ManyToOne
	@JoinColumn(name="pharmacy_id")
	private Pharmacy pharmacy;
	@ManyToOne
	@JoinColumn(name="insurance_id")
	private Insurance insurance;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="customers_roles",
	joinColumns = @JoinColumn(name="customer_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id"))
	private Collection<Role> roles;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="customer_prescriptions", 
	joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="prescription_id", referencedColumnName = "id"))
	private List<Prescriptions> prescriptions;
	
	
	public Customer(String firstName, String lastName, String email, String password, Pharmacy pharmacy,
			Insurance insurance, Collection<Role> roles, List<Prescriptions> prescriptions) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.pharmacy = pharmacy;
		this.insurance = insurance;
		this.roles = roles;
		this.prescriptions = prescriptions;
	}
	
	
	
	
	
	
	
}
