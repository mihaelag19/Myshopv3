package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import ro.itschool.entity.Order;
import ro.itschool.repository.ProductRepository;
import ro.itschool.repository.RoleRepository;
import ro.itschool.repository.UserRepository;

public class OrderController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

 //   @PostMapping



}
