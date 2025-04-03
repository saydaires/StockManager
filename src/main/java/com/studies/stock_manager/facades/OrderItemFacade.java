package com.studies.stock_manager.facades;
import com.studies.stock_manager.entities.OrderItem;
import com.studies.stock_manager.services.OrderItemService;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class OrderItemFacade {
    private final OrderItemService orderItemService;

    public OrderItemFacade(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    public void create(OrderItem orderItem) {
        orderItemService.create(orderItem);
    }

    public OrderItem getById(long id) {
        return orderItemService.getById(id);
    }

    public List<OrderItem> getAll() {
        return orderItemService.getAll();
    }

    public void delete(long id) {
        orderItemService.delete(id);
    }
}
