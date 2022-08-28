package ro.itschool.service;

import org.springframework.stereotype.Service;
import ro.itschool.entity.Cart;
import ro.itschool.entity.MyUser;
import ro.itschool.entity.Product;
import ro.itschool.exception.CustomException;

import java.util.List;
@Service
public interface CartService {

    void deleteById(Long id) throws CustomException;


    List<Product> getProducts(Product product);


}
