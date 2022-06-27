package com.travisMollohan.wellnessPortal.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.travisMollohan.wellnessPortal.controller.dto.CustomerRegistrationDto;
import com.travisMollohan.wellnessPortal.dao.CustomerRepository;
import com.travisMollohan.wellnessPortal.entity.Customer;
import com.travisMollohan.wellnessPortal.entity.Role;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
		customerRepository = theCustomerRepository;
	}
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public List<Customer> findAll() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int id) {
		Optional<Customer> result = customerRepository.findById(id);
		Customer theCustomer = null;
		if(result.isPresent()) {
			theCustomer = result.get();
		} else {
			throw new RuntimeException("No customer with that Id");
		}
		return theCustomer;
	}

	@Override
	public void save(CustomerRegistrationDto customerRegistrationDto) {
		
	Customer customer = new Customer(customerRegistrationDto.getFirstName(), customerRegistrationDto.getLastName(),
				customerRegistrationDto.getEmail(), passwordEncoder.encode(customerRegistrationDto.getPassword()), customerRegistrationDto.getPharmacy(), 
				customerRegistrationDto.getInsurance(), Arrays.asList(new Role("ROLE_USER")), customerRegistrationDto.getPrescriptions());
		
		customerRepository.save(customer);

	}

	@Override
	public void deleteById(int id) {
		customerRepository.deleteById(id);

	}
	
	@Override
	public void deletePrescriptionsById(int customerId, int prescriptionId) {
		customerRepository.deletePrescriptionsById(customerId, prescriptionId);
	}

	@Override
	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	@Override
	public void update(Customer theCustomer) {
		customerRepository.save(theCustomer);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer theCustomer = customerRepository.findByEmail(username);
		if(theCustomer == null) {
			throw new UsernameNotFoundException("Invalide email or password");
		}
		return new org.springframework.security.core.userdetails.User(theCustomer.getEmail(), theCustomer.getPassword(), mapRolesToAuthorities(theCustomer.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
	
	}

	
	
}
