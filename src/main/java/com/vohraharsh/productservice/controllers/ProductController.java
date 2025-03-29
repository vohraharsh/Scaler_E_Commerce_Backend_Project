package com.vohraharsh.productservice.controllers;

import com.vohraharsh.productservice.models.Product;
import com.vohraharsh.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;


    //This is dependency injection via constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")  //Used to retrieve all data.
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping()  //Used to create a new resource.
    public Product addProduct(@RequestBody Product product) {
        return new Product();
    }

    @PutMapping("/{id}")   //Replace an existing resource with an updated version.
    public Product updateProductById(@PathVariable("id") Long id, @RequestBody Product product ) {
        return new Product();
    }

    @DeleteMapping("/{id}")  //Used to remove data.
    public void deleteProductById(@PathVariable("id") Long id) {

    }
}
