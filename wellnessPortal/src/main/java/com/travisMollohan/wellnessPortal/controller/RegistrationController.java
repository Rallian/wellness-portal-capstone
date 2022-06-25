package com.travisMollohan.wellnessPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travisMollohan.wellnessPortal.controller.dto.CustomerRegistrationDto;
import com.travisMollohan.wellnessPortal.entity.Customer;
import com.travisMollohan.wellnessPortal.entity.Insurance;
import com.travisMollohan.wellnessPortal.entity.Pharmacy;
import com.travisMollohan.wellnessPortal.service.CustomerService;
import com.travisMollohan.wellnessPortal.service.InsuranceService;
import com.travisMollohan.wellnessPortal.service.PharmacyService;

@Controller
@RequestMapping("/wellness")
public class RegistrationController {

	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private PharmacyService pharmacyService;
	@Autowired
	private InsuranceService insuranceService;
	
	
	// register page display
	@GetMapping("/registration")
	public String registrationPage(Model theModel) {
		// create a customer object for the form
		Customer theCustomer = new Customer();
		//find a list of pharmacies to select from
		List<Pharmacy> pharmacys = pharmacyService.findAll();
		//find a list of insurance plans to select from
		List<Insurance> insurances = insuranceService.findAll();
		//add all information to the model
		theModel.addAttribute("customer", theCustomer);
		theModel.addAttribute("pharmacys", pharmacys);
		theModel.addAttribute("insurances", insurances);
		return "registration";
	}
	
	//saves a new customer
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") CustomerRegistrationDto theCustomer) {
		//save the customer
		customerService.save(theCustomer);
		//use a redirect to prevent duplicate submissions
		return "redirect:/login";
	}
}
