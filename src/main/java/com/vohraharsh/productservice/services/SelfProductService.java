package com.vohraharsh.productservice.services;

import com.vohraharsh.productservice.exceptions.ProductNotFoundException;
import com.vohraharsh.productservice.models.Product;
import com.vohraharsh.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductServiceBean")
//@Primary
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {

        //Make a DB call to get the product with the given ID.
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException
                ("Product id: " + id + " Does not exist."));
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
