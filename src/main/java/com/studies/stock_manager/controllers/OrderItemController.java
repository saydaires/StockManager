package com.studies.stock_manager.controllers;

import com.studies.stock_manager.entities.OrderItem;
import com.studies.stock_manager.facades.OrderItemFacade;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stock-manager/order-item")
public class OrderItemController {
    private final OrderItemFacade orderItemFacade;

    public OrderItemController(OrderItemFacade orderItemFacade) {
        this.orderItemFacade = orderItemFacade;
    }

    @PostMapping
    public void create(@RequestBody OrderItem orderItem) {
        orderItemFacade.create(orderItem);

    }

    @GetMapping({"/id/{id}"})
    public OrderItem getById(@PathVariable long id) {
        return orderItemFacade.getById(id);
    }

    @GetMapping
    public List<OrderItem> getAll() {
        return orderItemFacade.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        orderItemFacade.delete(id);
    }
}
