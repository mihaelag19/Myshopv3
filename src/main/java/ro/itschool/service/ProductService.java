package ro.itschool.service;

import ro.itschool.entity.Order;
import ro.itschool.entity.Product;

import java.util.List;

public interface ProductService {

    Iterable<Product> getAllProducts();

    Product getProduct(long id);
    void save(Product product);

    List<Product> getAllProductsByOrderId(Long orderId);
}
