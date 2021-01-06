package com.wct.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wct.springdemo.entity.Customer;
import com.wct.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
//	need to inject customer service 
	@Autowired
	private CustomerService theCustomerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
//		get customers from service
		List<Customer> theCustomers = theCustomerService.getCustomers();
		
//		add the customers to model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	
@GetMapping("showFormForAdd")
public String showFormForAdd(Model theModel) {
	
//	create model attribute to bind form data 
	Customer theCustomer = new Customer();
	
	theModel.addAttribute("customer", theCustomer);
	
	
	
	return "customer-form";
}


@PostMapping("/saveCustomer")
public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
	
//	save the customer using our service 
	theCustomerService.saveCustomer(theCustomer);
	
	return "redirect:/customer/list";
}


@GetMapping("/showFormForUpdate")
public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
	
//	get the customer from service
	
	Customer theCustomer = theCustomerService.getCustomer(theId);
	
//	set customer as a model attribute to prepopulate the form 
	theModel.addAttribute("customer", theCustomer);
	
	
//	send teh attribute to form 
	
	return "customer-form";
}


@GetMapping("/delete")
public String showFormForDelete(@RequestParam("customerId") int theId , Model theModel) {
	
// delete the customer 
	theCustomerService.deleteCustomer(theId);
	
	return "redirect:/customer/list";
}
	
}
