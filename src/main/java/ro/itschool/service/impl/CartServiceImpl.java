package ro.itschool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ro.itschool.entity.Cart;
import ro.itschool.entity.Product;
import ro.itschool.exception.CustomException;
import ro.itschool.repository.CartRepository;
import ro.itschool.repository.ProductRepository;
import ro.itschool.repository.UserRepository;
import ro.itschool.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
     private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Override
    public void deleteById(Long id) throws CustomException {

    }

    @Override
    public List<Product> getProducts(Product product) {
        return productRepository.findAll();
    }

    @Override
    public void update(Cart cart) {this.cartRepository.save(cart);

    }
}
