package com.co.supermarket.web.controller;

import com.co.supermarket.domain.Product;
import com.co.supermarket.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controlador de una API Rest
@RestController
//Path o URL para hacer las peticiones
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Obtener todos los Productos de un SuperMercado")
    @GetMapping("/all")
    //ResponseEntity -> Ayuda a devolver la respuesta para los servicios REST
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un Producto con el Id")
    @GetMapping("/{id}")
    //@PathVariable -> {id} -> Cuando se le pasa como parámetro en la URL (Ejm: /products/20)
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId) {
        //Si encuentra el producto, entonces con el map, enviar el objeto Obtional<producto>
        //Y retornar un objeto de tipo ResponseEntity, que es como funciona una Function<> en el map
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Obtener los Productos por Id de la Categoría")
    @GetMapping("/forCategory/{categoryid}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryid") int categoryId){
        return productService.getByCategory(categoryId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Guardar un objeto Producto")
    @PostMapping("/save")
    //@RequestBody -> Para determinar que el parámetro es parte del cuerpo de la petición (hace parte del Body->row)
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @Operation(summary = "Eliminar un Producto con el Id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        return new ResponseEntity<>(productService.delete(productId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
