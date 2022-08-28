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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;
//   private Long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE)
    private Set<Product> products;

    @OneToOne(mappedBy = "cart")
    private MyUser myUser;
 double subtotal;

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public Set<Product> getProducts() {
  return products;
 }

 public void setProducts(Set<Product> products) {
  this.products = products;
 }

 public MyUser getMyUser() {
  return myUser;
 }

 public void setMyUser(MyUser myUser) {
  this.myUser = myUser;
 }

 public double getSubtotal() {
  return subtotal;
 }

 public void setSubtotal(double subtotal) {
  this.subtotal = subtotal;
 }

 public void setProduct(Product product) {
 }
}
