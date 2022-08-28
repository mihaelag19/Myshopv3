package ro.itschool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.itschool.entity.Product;
import ro.itschool.exception.CustomException2;
import ro.itschool.repository.ProductRepository;
import ro.itschool.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Long id) throws CustomException2 {


    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }
}
