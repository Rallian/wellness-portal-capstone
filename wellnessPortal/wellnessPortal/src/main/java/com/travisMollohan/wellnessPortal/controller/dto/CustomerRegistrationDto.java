package com.travisMollohan.wellnessPortal.controller.dto;

import java.util.List;

import com.travisMollohan.wellnessPortal.entity.Insurance;
import com.travisMollohan.wellnessPortal.entity.Pharmacy;
import com.travisMollohan.wellnessPortal.entity.Prescriptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Pharmacy pharmacy;
	private Insurance insurance;
	private List<Prescriptions> prescriptions;
	
	
}
