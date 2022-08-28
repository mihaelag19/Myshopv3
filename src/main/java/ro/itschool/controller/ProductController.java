package ro.itschool.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import ro.itschool.entity.Product;
import ro.itschool.exception.CustomException2;
import ro.itschool.repository.ProductRepository;
import ro.itschool.service.impl.ProductServiceImpl;
import ro.itschool.util.FileUploadUtil;

import java.io.IOException;
import java.util.List;


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



    @GetMapping("/AddNewProduct")
    public String addNewProduct(Model model) {
        Product product= new Product();
        model.addAttribute("product", product);
        return "AddNewProduct";
    }

    @PostMapping("/saveProduct")
    public RedirectView saveProduct(@ModelAttribute("product") Product product,
                                  @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        product.setPhotos(fileName);
        Product saveProduct = productService.save(product);
        String uploadDir = "product-photos/" + saveProduct.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return new RedirectView("/", true);
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable Long id, Model model) {
        model.addAttribute("product",productRepository.findById(id).get());
        return "products";
    }

    @GetMapping("/deleteProduct/{id}")
    public String delete(@PathVariable("id") Long id){
       productRepository.deleteById(id);
        return "redirect:/index";
    }


}