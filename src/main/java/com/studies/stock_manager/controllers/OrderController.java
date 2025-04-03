package com.studies.stock_manager.controllers;

import com.studies.stock_manager.entities.Order;
import com.studies.stock_manager.facades.OrderFacade;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stock-manager/order")
public class OrderController {
    private final OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @PostMapping
    public void create(@RequestBody Order order) {
        orderFacade.create(order);

    }

    @GetMapping({"/id/{id}"})
    public Order getById(@PathVariable long id) {
        return orderFacade.getById(id);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderFacade.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        orderFacade.delete(id);
    }
}
