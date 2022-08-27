package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cart {
   @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cart_id")
//    private Long id;
    @Column(name = "cart_id")
    private Long cartId;

//    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE)
//    private Set<Product> products;

    @OneToOne(mappedBy = "cart")
    private MyUser myUser;

}
