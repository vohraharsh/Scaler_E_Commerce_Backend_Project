package com.vohraharsh.productservice.services;

import com.vohraharsh.productservice.dtos.FakeStoreProductDto;
import com.vohraharsh.productservice.models.Category;
import com.vohraharsh.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {


    //This service implementation uses FakeStore to fetch products from FakeStore


    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImageUrl());

        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        /*
         product.setCategory(new Category());
         product.getCategory().setName(fakeStoreProductDto.getCategory());
        */

        return product;
    }

    @Override
    public Product getProductById(@PathVariable("id") Long id) {

        //Make a call to FakeStore and get the product with the given ID.

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        //Convert FakeStoreProductDto Object into Product Object.

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject
                ("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }
}
