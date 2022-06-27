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
public class HomePageController {

	@Autowired
	private CustomerService customerService;
	
	//home page display
		@GetMapping("/{customerEmail}")
		public String customerHomePage(@PathVariable String customerEmail, Model theModel) {
			//find customer based on id
			Customer theCustomer = customerService.findByEmail(customerEmail);
			//add customer to the model
			theModel.addAttribute("customer", theCustomer);
			return "home-page";
		}
}
