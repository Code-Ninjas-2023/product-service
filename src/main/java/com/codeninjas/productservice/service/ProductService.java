package com.codeninjas.productservice.service;

import com.codeninjas.productservice.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct (Product product);

    List<Product> getAllProducts ();

    public Optional<Product> getProductById (String id);

    void updateProduct(String id, Product product);

    void deleteProduct(String id);
}
