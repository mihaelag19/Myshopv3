package ro.itschool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.itschool.entity.Product;
import ro.itschool.repository.ProductRepository;
import ro.itschool.service.ProductService;

import java.util.List;

@Service

public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return null;
    }


    @Override
    public List<Product> getAllProductsByOrderId(Long orderId) {
        return productRepository.findByOrderId(orderId);
    }
}
