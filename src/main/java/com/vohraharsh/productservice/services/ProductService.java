package com.vohraharsh.productservice.services;

import com.vohraharsh.productservice.exceptions.ProductNotFoundException;
import com.vohraharsh.productservice.models.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface ProductService {

    Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

}
