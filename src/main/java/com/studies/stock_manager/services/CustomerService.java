package com.studies.stock_manager.services;

import com.studies.stock_manager.entities.Customer;
import com.studies.stock_manager.repositories.CustomerRepository;
import com.studies.stock_manager.services.exceptions.customer.CustomerNotFoundException;

import java.util.NoSuchElementException;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getById(long id) {
        try {
            return customerRepository.getById(id);
        }
        catch(NoSuchElementException error) {
            throw new CustomerNotFoundException("Customer Not Found!", error);
        }
    }
//    public boolean login() {}
}
