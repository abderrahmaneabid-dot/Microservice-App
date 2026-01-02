package com.abdo.mscomande.Feign;

import com.abdo.mscomande.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MS-PRODUCT")
public interface OpenFeignProductRest {

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Long id);
    //si on utilise la pagination on doit utiliser PagedModel<Product> sinon on peut utiliser List<Product>
    @GetMapping("/products")
    List<Product> getAllProducts();
}
