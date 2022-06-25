package com.travisMollohan.wellnessPortal.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.travisMollohan.wellnessPortal.controller.dto.CustomerRegistrationDto;
import com.travisMollohan.wellnessPortal.entity.Customer;

public interface CustomerService extends UserDetailsService {

	public List<Customer> findAll();
	
	public Customer findById(int id);
	
	public void save(CustomerRegistrationDto customerRegistrationDto);
	
	public void deleteById(int id);
	
	public void deletePrescriptionsById(int customerId, int prescriptionId);
	
	public Customer findByEmail(String email);
	
	public void update(Customer theCustomer);
}
