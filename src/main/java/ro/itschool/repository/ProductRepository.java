package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.itschool.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

   Product deleteByName(String name);

    Product findByName(String name);



    @Query(
            value = "SELECT * FROM product WHERE order_id = ?",
            nativeQuery = true)
    List<Product> findByOrderId(Long orderId);

    @Query
            (value = "select * from product where product_id=:id", nativeQuery = true)
    Product findAllById(@Param("id") long id);
}
