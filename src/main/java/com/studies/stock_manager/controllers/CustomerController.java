package com.studies.stock_manager.controllers;

import com.studies.stock_manager.entities.Customer;
import com.studies.stock_manager.facades.CustomerFacade;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stock-manager/customer")
public class CustomerController {
    private final CustomerFacade customerFacade;

    public CustomerController(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    @PostMapping
    public void create(@RequestBody Customer customer) {
        customerFacade.create(customer);

    }

    @GetMapping("/email/{email}")
    public Customer getByEmail(@PathVariable String email) {
        return customerFacade.findByEmail(email);
    }

    @GetMapping({"/id/{id}"})
    public Customer getById(@PathVariable long id) {
        return customerFacade.getBydId(id);
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerFacade.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        customerFacade.delete(id);
    }

    @PutMapping({"/{id}"})
    public void update(@PathVariable long id, @RequestBody Customer customer) {
        customerFacade.update(id, customer);
    }
}
