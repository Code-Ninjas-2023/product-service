package com.codeninjas.productservice.service;

import com.codeninjas.productservice.domain.Product;
import com.codeninjas.productservice.exception.ProductServiceException;

import java.util.List;

public interface ProductService {

    Product addProduct (Product product);

    List<Product> getAllProducts ();

    Product updateProduct(String id, Product product) throws ProductServiceException;

    void deleteProduct(String id) throws ProductServiceException;

    Product getProductById (String id);
}
