package com.co.supermarket.web.controller;

import com.co.supermarket.domain.Product;
import com.co.supermarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Controlador de una API Rest
@RestController

//Path o URL para hacer las peticiones
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    //@PathVariable -> {id} -> Cuando se le pasa como parámetro en la URL (Ejm: /products/20)
    public Optional<Product> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId);
    }
    @GetMapping("/forCategory/{categoryid}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryid") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    //@RequestBody -> Para determinar que el parámetro es parte del cuerpo de la petición (hace parte del Body->row)
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
