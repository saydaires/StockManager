package com.studies.stock_manager.repositories;
import com.studies.stock_manager.entities.Customer;
import com.studies.stock_manager.repositories.interfaces.CustomerJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerRepository {
    private final CustomerJpaRepository customerJpaRepository;

    public CustomerRepository(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    public void create(Customer customer) {
        customerJpaRepository.save(customer);
    }

    public Customer getById(long id) {
        return customerJpaRepository.findById(id).get();
    }

    public List<Customer> getAll() {
        return customerJpaRepository.findAll();
    }

    public void delete(long id) {
        customerJpaRepository.deleteById(id);
    }

    public void update(long id, Customer futureCustomer) {
        Customer customerDatabase = customerJpaRepository.findById(id).get();
        BeanUtils.copyProperties(futureCustomer, customerDatabase, "id");
        customerJpaRepository.save(customerDatabase);
    }

    public Customer findByEmail(String email) {
        return customerJpaRepository.findCustomerByEmail(email);
    }
}
