package ro.itschool.service;

import ro.itschool.entity.Product;
import ro.itschool.exception.CustomException2;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(Product product);


   List<Product> getAllProducts();

    void deleteById(Long id) throws CustomException2;


   Optional<Product> findById(long id);
}

