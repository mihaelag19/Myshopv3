package ro.itschool.repository;

import org.springframework.data.jpa.repository.Query;
import ro.itschool.entity.Order;
import ro.itschool.entity.Product;

import java.util.List;

public interface ProductRepository {


    void save(Product product);

    List<Product> findAll();
    @Query(
            value = "SELECT * FROM product WHERE order_id = ?",
            nativeQuery = true)
    List<Product> findByOrderId(Long orderId);
}
