package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.itschool.entity.Cart;
import ro.itschool.entity.Product;
import ro.itschool.repository.CartRepository;
import ro.itschool.repository.ProductRepository;
import ro.itschool.util.Constants;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/addToCart/{id}")
    public String addToCart(Product product, @PathVariable("id") Long id) {
        Cart cart = new Cart();
        cart.setCartId(id);
        cartRepository.save(cart);
        product.setCartId(product.getId());
        Product p = productRepository.findAllById(product.getId());
        p.setCartId(id);
        productRepository.save(p);
        return "redirect:/cart";
    }

    @GetMapping(value = "/cart")
    public String cart(Model model) {
        List<Object> objects = cartRepository.findAllBy();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < objects.size(); i++) {
            Product product = new Product();
            Object[] array = (Object[]) objects.get(i);
            Long cartId = (Long) array[1];
            String desc = (String) array[4];
            String name = (String) array[5];
            //String image = (String) array[6];
            Double price = (Double) array[6];
            product.setName(name);
            product.setDescription(desc);
            //product.setPictureUrl(image);
            product.setPrice(price);
            product.setCartId(cartId);
            products.add(product);
        }
        model.addAttribute("cart", products);
        return "cart";
    }

    @GetMapping("/delete/{cart_id}")
    public String delete(@PathVariable("cart_id") long cartId) {
        List<Object> objects = cartRepository.findAllBy();
        for (int i = 0 ; i < objects.size() ; i++) {
            Object[] arry = (Object[]) objects.get(i);
            Long cart_Id = (Long) arry[1];
            if (cart_Id.equals(cartId)) {
                cartRepository.deleteById(cartId);
                Product product = productRepository.findAllById((Long) arry[0]);
                product.setCartId(null);
                productRepository.save(product);
            }
        }
        return "redirect:/cart";
    }
}
