package com.studies.stock_manager.facades;
import com.studies.stock_manager.entities.Customer;
import com.studies.stock_manager.services.CustomerService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CustomerFacade {
    private final CustomerService customerService;

    public CustomerFacade(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void create(Customer customer) {
        customerService.create(customer);
    }

    public Customer getBydId(long id) {
        return customerService.getById(id);
    }

    public List<Customer> getAll() {
        return customerService.getAll();
    }

    public void delete(long id) {
        customerService.delete(id);
    }

    public void update(long id, Customer customer) {
        customerService.update(id, customer);
    }

    public Customer findByEmail(String email) {
        return customerService.findByEmail(email);
    }
}
