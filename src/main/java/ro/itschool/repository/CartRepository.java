package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ro.itschool.entity.Cart;
import ro.itschool.entity.Order;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Transactional
    void deleteById(Long id);

    Optional<Cart> findById(Long id);


    @Query(
            value = "SELECT * FROM order WHERE user_id = ?",
            nativeQuery = true)
    List<Order> findByUserId(Long userId);

    @Query
            (value = "select * from cart inner join product where product.cart_id=cart.cart_id;", nativeQuery = true)
    List<Object> findAllBy();

    @Query
            (value = "select * from cart", nativeQuery = true)
    List<Cart> findAll();

}

