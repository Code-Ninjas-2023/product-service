package com.codeninjas.productservice.service;

import com.codeninjas.productservice.domain.Product;
import com.codeninjas.productservice.exception.ProductServiceException;
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
    public Product updateProduct(String id, Product product) throws ProductServiceException {
        Product newProduct = productRepository.findById(id).orElseThrow(() -> new ProductServiceException("Product not found"));
        newProduct.setId(id);
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        productRepository.save(newProduct);
        return newProduct;
    }

    @Override
    public void deleteProduct(String id) throws ProductServiceException {
        productRepository.findById(id).orElseThrow(() -> new ProductServiceException("Product not found"));
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(String id) throws ProductServiceException {
        return productRepository.findById(id).orElseThrow(() -> new ProductServiceException("Product not found"));
    }

}
