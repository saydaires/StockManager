package com.studies.stock_manager.facades;
import com.studies.stock_manager.entities.Order;
import com.studies.stock_manager.services.OrderService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class OrderFacade {
    private final OrderService orderService;

    public OrderFacade(OrderService orderService) {
        this.orderService = orderService;
    }

    public void create(Order order) {
        orderService.create(order);
    }

    public Order getById(long id) {
        return orderService.getById(id);
    }

    public List<Order> getAll() {
        return orderService.getAll();
    }

    public void update(long id, Order order) {
        orderService.update(id, order);
    }

    public void delete(long id) {
        orderService.delete(id);
    }
}
