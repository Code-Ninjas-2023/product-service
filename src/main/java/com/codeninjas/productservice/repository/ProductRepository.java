package com.codeninjas.productservice.repository;

import com.codeninjas.productservice.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product getProductById(Long id);

}
