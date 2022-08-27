package ro.itschool.entity;


import jakarta.persistence.*;
import lombok.*;



@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;



    private String name;
    private Double price;
    private String description;
    private String pictureUrl;
    private Long cartId;

//    @ManyToOne
//    @JoinColumn(name = "cart_id")
//    @ToString.Exclude
//    private Cart cart;
}
