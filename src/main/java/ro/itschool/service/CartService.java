package ro.itschool.service;

import ro.itschool.entity.Cart;
import ro.itschool.entity.Product;
import ro.itschool.exception.CustomException;

import java.util.List;

public interface CartService {

    void deleteById(Long id) throws CustomException;


    List<Product> getProducts(Product product);


    void update(Cart Cart);

}
