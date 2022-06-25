package com.travisMollohan.wellnessPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travisMollohan.wellnessPortal.entity.Customer;
import com.travisMollohan.wellnessPortal.service.CustomerService;

@Controller
@RequestMapping("/wellness")
public class MyPrescriptionsController {

	@Autowired
	private CustomerService customerService;
	
	
	//shows current prescriptions
	@GetMapping("/{customerId}/myPrescriptions")
	public String myPrescriptions(@PathVariable int customerId, Model theModel) {
		//find the customer
		Customer theCustomer = customerService.findById(customerId);
		//add customer to the model
		theModel.addAttribute("customer", theCustomer);
		return "my-prescriptions-page";
	}
	
	
	//deletes prescriptions
	@RequestMapping("/deleteCustomerPrescription/{customerId}/{prescriptionId}")
	public String deleteCustomerPrescription(@PathVariable int customerId, @PathVariable int prescriptionId) {
		// call custom delete query
		customerService.deletePrescriptionsById(customerId, prescriptionId);
		//redirect back to prescriptions page
		return "redirect:/wellness/"+customerId+"/myPrescriptions";
	}
}
