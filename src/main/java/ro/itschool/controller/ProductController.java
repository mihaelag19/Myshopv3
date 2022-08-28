package ro.itschool.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.itschool.entity.Product;
import ro.itschool.exception.CustomException;
import ro.itschool.exception.CustomException2;
import ro.itschool.repository.ProductRepository;
import ro.itschool.service.impl.ProductServiceImpl;
import ro.itschool.util.Constants;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductServiceImpl productService;


    //----------VIEW ALL PRODUCTS FOR USER----------------------------------------------
    @GetMapping("/viewProducts")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "AllProducts";
    }
    //----------VIEW ALL PRODUCTS FOR ADMIN----------------------------------------------
    @GetMapping("/allProducts")
    public String getProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }
    //----------ADD PRODUCTS FOR ADMIN----------------------------------------------

    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("productObj", new Product());
        return "productsAdd";
    }

    @GetMapping("/saveProduct")
    public String saveProduct() {
        return "saveProduct";
    }


    @PostMapping("/saveProduct")
    public String saveProduct(@RequestParam("file") List<MultipartFile> file, @ModelAttribute Product product, Model model) throws IOException {
        model.addAttribute("productObj", product);
        String imageUrl = file.get(0).getOriginalFilename();
        product.setPictureUrl(imageUrl);
        productRepository.save(product);
        return "redirect:/allProducts";
    }

    //----------ADD PRODUCTS FOR ADMIN----------------------------------------------


    @DeleteMapping("/deleteProduct/{id}")
    public String delete(@ModelAttribute Model model, @PathVariable Long id) throws CustomException2 {
        productRepository.deleteById(id);
        return "redirect:/allProducts";


    }
}