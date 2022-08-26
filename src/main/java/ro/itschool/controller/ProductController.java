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
    private ProductRepository productRepository;

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/viewProducts")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "AllProducts";
    }

    @GetMapping("/allproducts")
    public String getProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

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
        //   product.setCartId(product.getId());
        productRepository.save(product);
        return "redirect:/allproducts";
    }

    @GetMapping("/deleteProduct/{id}")
    public String delete(@PathVariable("id") long id) throws CustomException {
        productService.findbyId(id);
        return "redirect:/allproducts";
    }

    @GetMapping("/updateProduct/{name}")
    public String updateProduct(@PathVariable String name) throws CustomException {
        Optional.ofNullable(productRepository.findByName(name)).orElseThrow(() -> new CustomException("Product does not exist"));
        return "redirect:/allproducts";
    }

@DeleteMapping("/deleteProduct/{id}")
public String delete(@PathVariable Long id) throws CustomException2 {

        productService.deleteById(id);
    return "redirect:allproducts";
}

}
