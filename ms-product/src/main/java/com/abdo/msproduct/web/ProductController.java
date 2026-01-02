package com.abdo.msproduct.web;



import com.abdo.msproduct.Repos.ProductRepository;
import com.abdo.msproduct.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    ProductRepository productRepository;

    @GetMapping("/products")
    List<Product> Allproduct(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable Long id){
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping("/products")
    Product saveProduct(@RequestBody Product client) {
        return productRepository.save(client);
    }

    @PutMapping("/products/{id}")
    Product updateProduct(@PathVariable Long id, @RequestBody Product pr) {
        Product product = productRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(pr, product);
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    void deleteClient(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

}
