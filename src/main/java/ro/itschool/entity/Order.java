package ro.itschool.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter
@Getter

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private Double amount;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dateCreated;
    private String status;
//    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private MyUser user;
    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
    private Set<Product> products;

//    @Transient
//    public Double getTotalOrderPrice() {
//        double sum = 0D;
//        List<OrderProduct> orderProducts = getOrderProducts();
//        for (OrderProduct op : orderProducts) {
//            sum += op.getTotalPrice();
//        }
//        return sum;
//    }
//
//    @Transient
//    public int getNumberOfProducts() {
//        return this.orderProducts.size();
//    }



}

