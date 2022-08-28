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

    @Query(
            value = "SELECT * FROM cart WHERE user_id = ?",
            nativeQuery = true)
    List<Cart> findByUserId(Long userId);
}




