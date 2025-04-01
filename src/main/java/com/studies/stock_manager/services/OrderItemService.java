package com.studies.stock_manager.services;
import com.studies.stock_manager.entities.OrderItem;
import com.studies.stock_manager.repositories.OrderItemRepository;
import com.studies.stock_manager.services.exceptions.EntityNotFoundException;
import java.util.NoSuchElementException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public void create(OrderItem orderItem) {
        orderItemRepository.create(orderItem);
    }

    public OrderItem getById(long id) {
        try {
            return orderItemRepository.getById(id);
        }
        catch(NoSuchElementException error) {
            throw new EntityNotFoundException("OrderItem Not Found!", error);
        }
    }

    public List<OrderItem> getAll() {
        return orderItemRepository.getAll();
    }

    public void delete(long id) {
        try {
            orderItemRepository.delete(id);
        }
        catch(IllegalArgumentException error) {
            throw new EntityNotFoundException("Field Id cannot be null!", error);
        }
    }
}
