package ro.itschool.service;

import ro.itschool.entity.Order;
import ro.itschool.exception.CustomException;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void deleteById(Long id) throws CustomException;

    void save(Order order);

    List<Order> getAllOrders();

    List<Order> getAllOrdersByUserId(Long userId);

    Optional<Order> findById(Long id);

//    Order create(Order order);

    void update(Order order);

}