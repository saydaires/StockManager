package com.studies.stock_manager.repositories.interfaces;
import com.studies.stock_manager.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByEmail(String email);
}
