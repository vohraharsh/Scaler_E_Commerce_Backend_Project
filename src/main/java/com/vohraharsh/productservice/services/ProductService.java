package com.vohraharsh.productservice.services;

import com.vohraharsh.productservice.models.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface ProductService {

    Product getProductById(@PathVariable("id") Long id);

    List<Product> getAllProducts();

}
