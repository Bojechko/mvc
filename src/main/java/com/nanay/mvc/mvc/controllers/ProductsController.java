package com.nanay.mvc.mvc.controllers;

import com.nanay.mvc.mvc.entities.Product;
import com.nanay.mvc.mvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public String showProducts(Model model){
        Product product = new Product(null, null, 0);
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("product", product);
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute(value = "product") Product product){
        productService.add(product);
        return "redirect:/products";
    }

    @GetMapping("/remove/{id}")
    public String removeProduct(){
        return "1";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable(value = "id") Long id){
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product-page";
    }
}
