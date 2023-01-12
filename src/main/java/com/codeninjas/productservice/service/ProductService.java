package com.codeninjas.productservice.service;

import com.codeninjas.productservice.domain.Product;

import java.util.List;

public interface ProductService {

    Product addProduct (Product product);

    List<Product> getAllProducts ();

    Product updateProduct(String id, Product product);

    void deleteProduct(String id);

    Product getProductById (String id);
}
