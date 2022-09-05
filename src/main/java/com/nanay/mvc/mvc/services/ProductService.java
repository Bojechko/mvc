package com.nanay.mvc.mvc.services;
import com.nanay.mvc.mvc.entities.Product;
import com.nanay.mvc.mvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public void add(Product product){
        productRepository.saveProduct(product);
    }

    public Product getById(Long id){
        return productRepository.getById(id);
    }
}
