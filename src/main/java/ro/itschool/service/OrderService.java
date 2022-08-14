package ro.itschool.service;

import ro.itschool.entity.Order;

import java.util.List;

public interface OrderService {
    void save(Order order);

    List<Order> getAllOrders();

    List<Order> getAllOrdersByUserId(Long userId);

    Order create(Order order);

    void update(Order order);
}
