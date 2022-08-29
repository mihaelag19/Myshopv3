package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ro.itschool.entity.Product;
import ro.itschool.global.GlobalData;
import ro.itschool.repository.CartRepository;
import ro.itschool.service.ProductService;

@Controller
public class CartController {

  @Autowired
  ProductService productService;
  @Autowired
    CartRepository cartRepository;


    //----------ADD PRODUCTS TO CART----------------------------------------------
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable long id){
        GlobalData.cart.add(productService.findById(id).get());
        return "redirect:/cart";
    }

    @GetMapping(value = "/cart")
    public String cartGet(Model model){
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
   model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }



//    @RequestMapping("/removeItem/{index}")
//    public String cartItemRemove(@PathVariable int index){
//        GlobalData.cart.remove(productService.findById(index).get());
//        return "redirect:/cart";
//    }

    @GetMapping(value ="/placeOrder")
    public String checkout(Model model){

       return "placeOrder";
    }


//    @GetMapping(value = "/cart")
//    public String cart(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        MyUser user= userRepository.findByUsernameIgnoreCase(authentication.getName());
//        Set <Product> products= user.getCart().getProducts();
//        model.addAttribute("cart", products);
//        return "cart";
//
//    };

//    //----------ADD PRODUCTS TO CART----------------------------------------------
//    @RequestMapping("/addToCart/{id}")
//    public String addProductToCart(@PathVariable("id") Long id) {
//        final Optional<Cart> cart = cartRepository.findById(id);
//        final Optional<Product> product =productRepository.findById(id);
//            cart.get().getProducts().add(product);
//            cartService.update(cart.get());
//            return "redirect:/cart";
//        }
//        return ("Cart not found : " + id);
//    }


//    @RequestMapping(value = "/addToCart/{id}")
//    public String addProductToCart(@PathVariable("id") Long id, Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        MyUser user= userRepository.findByUsernameIgnoreCase(authentication.getName());
//        Set <Product> products= user.getCart().getProducts();
//        products.add(productRepository.findById(id).get());
//
//        Cart cart=user.getCart();
//        cart.setProducts(products);
//        user.setCart(cart);
//        userRepository.save(user);
//        return "redirect:/cart";
//    }



}
