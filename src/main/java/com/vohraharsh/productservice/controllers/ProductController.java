package com.vohraharsh.productservice.controllers;

import com.vohraharsh.productservice.exceptions.ProductNotFoundException;
import com.vohraharsh.productservice.models.Product;
import com.vohraharsh.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {

        /*
        ResponseEntity<Product> responseEntity = null;

        try {
            Product product = productService.getProductById(id);
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        } catch (ProductNotFoundException e){
            System.out.println(e.getMessage());
            responseEntity = new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }

         */

        return productService.getProductById(id);

        //Product product = productService.getProductById(id);
        //return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);

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
