package com.codeninjas.productservice.service;

import com.codeninjas.productservice.domain.Product;
import com.codeninjas.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
//    private static List<Product> products = new ArrayList<>();
//
//    private static int productsCount = 0;
//
//    static {
//        products.add(new Product("Nati","pen" ,5.54));
//        products.add(new Product(++productsCount, "Neba","pencil" ,5.54));
//        products.add(new Product(++productsCount, "Mahi","Chair" ,5.54));
//
//    }

    @Override
    public Product updateProduct(String id, Product product) {
        Product newProduct = productRepository.findById(id).get();
        newProduct.setId(id);
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        productRepository.save(newProduct);
        return newProduct;
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
