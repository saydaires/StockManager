package com.studies.stock_manager.services;
import com.studies.stock_manager.entities.Customer;
import com.studies.stock_manager.repositories.CustomerRepository;
import com.studies.stock_manager.services.exceptions.DelayedRecordException;
import com.studies.stock_manager.services.exceptions.EntityNotFoundException;
import org.springframework.dao.OptimisticLockingFailureException;
import java.util.NoSuchElementException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void create(Customer customer) {
        customerRepository.create(customer);
    }

    public Customer getById(long id) {
        try {
            return customerRepository.getById(id);
        }
        catch(NoSuchElementException error) {
            throw new EntityNotFoundException("Customer Not Found!", error);
        }
    }

    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    public void delete(long id) {
        try {
            customerRepository.delete(id);
        }
        catch(IllegalArgumentException error) {
            throw new EntityNotFoundException("Field Id cannot be null!", error);
        }
    }

    public void update(Customer customer) {
        try {
            customerRepository.update(customer);
        }
        catch(IllegalArgumentException error) {
            throw new EntityNotFoundException("Object cannot be null!", error);
        }
        catch(OptimisticLockingFailureException error) {
            throw new DelayedRecordException("Application data in conflict with the database!", error);
        }
    }
}
