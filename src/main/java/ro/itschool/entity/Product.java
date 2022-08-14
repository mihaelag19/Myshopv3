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
    @ManyToOne
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    private Order order;
}
