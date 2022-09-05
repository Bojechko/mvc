package com.nanay.mvc.mvc.repositories;
import com.nanay.mvc.mvc.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        products.add(new Product(1L, "Cat", 300));
        products.add(new Product(2L, "Dog", 200));
        products.add(new Product(3L, "Rat", 100));
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getByName(String title){
        return products.stream().filter(p -> p.getName().equals(title)).findFirst().get();
    }

    public Product getById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public void saveProduct(Product product){
        products.add(product);
    }
}
