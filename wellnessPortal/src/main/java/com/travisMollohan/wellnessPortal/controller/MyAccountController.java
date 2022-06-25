package com.travisMollohan.wellnessPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travisMollohan.wellnessPortal.entity.Customer;
import com.travisMollohan.wellnessPortal.service.CustomerService;

@Controller
@RequestMapping("/wellness")
public class MyAccountController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	//shows current account
	@GetMapping("/{customerId}/myAccount")
	public String myAccountPage(@PathVariable int customerId, Model theModel) {
		//find customer
		Customer theCustomer = customerService.findById(customerId);
		// add to model
		theModel.addAttribute("customer", theCustomer);
		return "my-account-page";
	}
	
	
	//allows for the account to be updated
	@GetMapping("/accountUpdate/{customerId}")
	public String accountUpdate(@PathVariable int customerId, Model theModel) {
		// find customer info
		Customer theCustomer = customerService.findById(customerId);
		// add to the model
		theModel.addAttribute("customer", theCustomer);
		return "update-account-page";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("customer") Customer theCustomer) {
		String tempPass= theCustomer.getPassword();
		if(tempPass == null) {
			// if customer chooses not to update their password, will find the old one and apply it.
			Customer tempCustomer = customerService.findById(theCustomer.getId());
			theCustomer.setPassword(tempCustomer.getPassword());
		}
		//otherwise encrypts the new password.
		theCustomer.setPassword(passwordEncoder.encode(tempPass));
		customerService.update(theCustomer);
		
		return "redirect:/wellness/"+ theCustomer.getEmail();
	}
}
