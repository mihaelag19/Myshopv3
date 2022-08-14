package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ro.itschool.entity.Order;
import ro.itschool.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional
    void deleteById(Long id);
    Optional<Product> findById(Long id);




    List<Product> findAll();
    @Query(
            value = "SELECT * FROM product WHERE order_id = ?",
            nativeQuery = true)
    List<Product> findByOrderId(Long orderId);
}
