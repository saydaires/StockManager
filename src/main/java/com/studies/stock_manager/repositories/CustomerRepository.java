package com.studies.stock_manager.repositories;
import com.studies.stock_manager.entities.Customer;
import com.studies.stock_manager.repositories.interfaces.CustomerJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerRepository {
    private CustomerJpaRepository customerJpaRepository;

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

    public void update(Customer futureCustomer) {
        Customer customerDatabase = customerJpaRepository.findById(futureCustomer.getId()).get();

        customerDatabase.setEmail(futureCustomer.getEmail());
        customerDatabase.setPassword(futureCustomer.getPassword());

        customerJpaRepository.save(customerDatabase);
    }
}
