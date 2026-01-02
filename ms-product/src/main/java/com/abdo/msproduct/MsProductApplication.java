package com.abdo.msproduct;

import com.abdo.msproduct.Repos.ProductRepository;
import com.abdo.msproduct.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProductApplication.class, args);
    }
    @Bean
    CommandLineRunner init(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(2300.0)
                    .build());
            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1200.0)
                    .build());
            productRepository.save(Product.builder()
                    .name("Smartphone")
                    .price(800.0)
                    .build());
            productRepository.findAll().forEach(p->{
                System.out.println(p);
            });
        };
    }

}
