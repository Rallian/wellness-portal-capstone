package com.travisMollohan.wellnessPortal;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.travisMollohan.wellnessPortal.controller.dto.CustomerRegistrationDto;
import com.travisMollohan.wellnessPortal.entity.Customer;
import com.travisMollohan.wellnessPortal.entity.Insurance;
import com.travisMollohan.wellnessPortal.entity.Pharmacy;
import com.travisMollohan.wellnessPortal.entity.Prescriptions;
import com.travisMollohan.wellnessPortal.service.CustomerService;
import com.travisMollohan.wellnessPortal.service.InsuranceService;
import com.travisMollohan.wellnessPortal.service.PharmacyService;
import com.travisMollohan.wellnessPortal.service.PrescriptionsService;

@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	InsuranceService insuranceService;
	@Autowired
	PharmacyService pharmacyService;
	@Autowired
	PrescriptionsService prescriptionService;
	
	// create a new customer
	@BeforeEach
	public void createCustomer() {
		Pharmacy pharmacy = pharmacyService.findById(1);
		Insurance insurance = insuranceService.findById(1);
		//add all prescriptions to bugs
		List<Prescriptions> prescriptions = prescriptionService.findAll();
		CustomerRegistrationDto customer = new CustomerRegistrationDto("Bugs", "Bunny", "bugs@gmail.com", "pass", pharmacy, insurance, prescriptions);
		customerService.save(customer);
	}

	@Test
	public void findByEmailTest() {
		// test to see if the insurance is the same one we set, searching for customer by email.
		Assertions.assertTrue(customerService.findByEmail("bugs@gmail.com").getInsurance().getId() == 1);
	}
	// delete prescriptions from customer
	@Test
	public void deletePrescriptionsFromCustomer() {
		Customer customer = customerService.findByEmail("bugs@gmail.com");
		// call the delete
		customerService.deletePrescriptionsById(customer.getId(), 1);
		
		
	    
	}
	
	// delete the newly created customer
	@AfterEach
	public void deleteCustomer() {
		Customer customer = customerService.findByEmail("bugs@gmail.com");
		customerService.deleteById(customer.getId());
	}
	
}