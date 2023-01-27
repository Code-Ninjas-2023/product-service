package com.codeninjas.productservice.controller;

import com.codeninjas.productservice.domain.Product;
import com.codeninjas.productservice.exception.ProductServiceException;
import com.codeninjas.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

private final ProductService productService;

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateById(@PathVariable String id, @Valid @RequestBody Product product) throws ProductServiceException {
        productService.updateProduct(id ,product);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteById(@PathVariable String id) throws ProductServiceException {
        productService.deleteProduct(id);
        return new  ResponseEntity<String>(HttpStatus.OK);

    }

    @GetMapping("{id}")
    public Product getProductsById(@PathVariable String id) throws ProductServiceException{
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        return productService.addProduct(product);
    }

}
