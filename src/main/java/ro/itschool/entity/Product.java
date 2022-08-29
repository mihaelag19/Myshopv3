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
    private String photos;
//    private Long cartId;



//    @Transient
//    public String getPhotosImagePath() {
//        if (photos == null);
//
//
//        return "/product-photos/" +  "/" + photos;
//    }


    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @ToString.Exclude
    private Cart cart;
}
