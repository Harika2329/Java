package com.example.pointcalculater.util;

import java.util.ArrayList;
import java.util.List;

import com.example.pointcalculater.model.Customer;

public class CustomerData {
	
	public static List<Customer> getAllCustomers() {
		List<Customer> customers=new ArrayList<>();	


		Customer customer1=new Customer();
		customer1.setCustomerId(1l);
		customer1.setCustomerName("Micheal ");		
		customers.add(customer1);

		Customer customer2=new Customer();
		customer2.setCustomerId(2l);
		customer2.setCustomerName("Sachin ");		
		customers.add(customer2);

		Customer customer3=new Customer();
		customer3.setCustomerId(3l);
		customer3.setCustomerName("Shane ");		
		customers.add(customer3);


		return customers;
	}

}
