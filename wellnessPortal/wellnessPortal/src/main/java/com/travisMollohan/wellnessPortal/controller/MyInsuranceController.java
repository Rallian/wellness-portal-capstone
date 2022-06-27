package com.travisMollohan.wellnessPortal.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.travisMollohan.wellnessPortal.entity.Customer;
import com.travisMollohan.wellnessPortal.entity.Insurance;
import com.travisMollohan.wellnessPortal.service.CustomerService;
import com.travisMollohan.wellnessPortal.service.InsuranceService;

@Controller
@RequestMapping("/wellness")
public class MyInsuranceController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private InsuranceService insuranceService;
	
	
	//shows current insurance and allows for updates
	@GetMapping("/{customerId}/myInsurance")
	public String myInsurance(@PathVariable int customerId, Model theModel) {
		//find customer by id
		Customer theCustomer = customerService.findById(customerId);
		//find all insurances to list for customer
		List<Insurance> insurances = insuranceService.findAll();
		// add to the model
	theModel.addAttribute("aCustomer", theCustomer);
	theModel.addAttribute("insurances", insurances);
	return "my-insurance-page";
	}
	
	//updates the insurance
	@PostMapping("/updateInsurance")
	public String updateInsurance(@ModelAttribute("aCustomer") Customer theCustomer) {
		// save the customer object
		customerService.update(theCustomer);
		// redirect to insurance page to see update
		
		return "redirect:/wellness/"+ theCustomer.getId()+"/myInsurance";
	}
}
