package com.studies.stock_manager.services;
import com.studies.stock_manager.entities.Order;
import com.studies.stock_manager.repositories.OrderRepository;
import com.studies.stock_manager.services.exceptions.DelayedRecordException;
import com.studies.stock_manager.services.exceptions.EntityNotFoundException;
import java.util.NoSuchElementException;
import java.util.List;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(Order order) {
        orderRepository.create(order);
    }

    public Order getById(long id) {
        try {
            return orderRepository.getById(id);
        }
        catch(NoSuchElementException error) {
            throw new EntityNotFoundException("Order Not Found!", error);
        }
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }


    public void update(Order order) {
        try {
            orderRepository.update(order);
        }
        catch(IllegalArgumentException error) {
            throw new EntityNotFoundException("Object cannot be null!", error);
        }
        catch(OptimisticLockingFailureException error) {
            throw new DelayedRecordException("Application data in conflict with the database!", error);
        }
    }

    public void delete(long id) {
        try {
            orderRepository.delete(id);
        } catch (IllegalArgumentException error) {
            throw new EntityNotFoundException("Field Id cannot be null!", error);
        }
    }
}
