package ro.itschool.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ro.itschool.entity.Product;
import ro.itschool.service.ProductService;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = {"", "/"})
    public Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
}
