package ro.itschool.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;


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

    @NotNull
    @Basic(optional = false)
    private String name;
    private Double price;
    private String description;
    private String pictureUrl;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    private Order order;
}
