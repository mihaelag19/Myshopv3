package ro.itschool.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Product;
import ro.itschool.exception.CustomException;
import ro.itschool.repository.ProductRepository;

import java.util.Optional;


@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/allproducts")
    public String getProducts(Model model) {
        model.addAttribute("products",productRepository.findAll());
        return "allproducts";
    }
    @GetMapping("/saveProduct")
    public String saveProduct(Model model) {
        model.addAttribute("productObj",new Product());
        return "saveProduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product product,Model model){
        model.addAttribute("productObj",product);
        productRepository.save(product);
        return "redirect:allproducts";
    }
    @GetMapping("/updateProduct/{name}")
    public String updateProduct(@PathVariable String name) throws CustomException{
        Optional.ofNullable(productRepository.findByName(name)).orElseThrow(()->new CustomException("User does not exist"));
        return "updateProduct";
    }
    @DeleteMapping("/deleteProduct/{name}")
    public String delete(@PathVariable String name) throws  CustomException{
        Optional.ofNullable(productRepository.findByName(name)).orElseThrow(()->new CustomException("User does not exist"));
        productRepository.deleteByName(name);
        return "redirect:allproducts";
    }
//
//    @PostMapping("/addToCart")
//    public String addToCart(@ModelAttribute Product product, Cart cart, Model model){
//        model.addAttribute("productObj", product);
//
//    }

}
