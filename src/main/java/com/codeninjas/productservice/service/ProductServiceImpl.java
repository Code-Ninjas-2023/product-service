package com.codeninjas.productservice.service;

import com.codeninjas.productservice.domain.Product;
import com.codeninjas.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(String id, Product product) {
        Product newProduct = productRepository.findById(id).get();
        newProduct.setId(id);
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        productRepository.save(newProduct);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).get();
    }

}
