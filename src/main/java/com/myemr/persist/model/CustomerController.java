package com.myemr.persist.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myemr.persist.repository.CustomerRepository;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepository custRepository;

	@PostMapping(value="/save")
	public String readerBooks(@RequestParam String firstName, @RequestParam String lastName, Model model) {
		
		Customer cust = new Customer(firstName, lastName);
				
		custRepository.save(cust);
		
		return "saved";
	}
	
	@GetMapping(value="/test")
	public String test() {
		return "test";
	}
	
	
	public CustomerRepository getCustRepository() {
		return custRepository;
	}

	public void setCustRepository(CustomerRepository custRepository) {
		this.custRepository = custRepository;
	}
	
}
