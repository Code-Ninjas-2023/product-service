package com.codeninjas.productservice.service;

import com.codeninjas.productservice.domain.Product;
import com.codeninjas.productservice.exception.ProductServiceException;
import com.codeninjas.productservice.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @Before
    public void setUp() {
        product = new Product();
        product.setId("1123");
        product.setName("laptop");
        product.setDescription("macbook pro");
        product.setPrice(BigDecimal.valueOf(999.00));
    }

    @Test
    public void givenUpdateProductIsSuccessful() throws ProductServiceException {
        Product newProduct = new Product();
        Mockito.when(productRepository.findById(any())).thenReturn(Optional.ofNullable(product));
        newProduct.setId("1123");
        newProduct.setName("laptop");
        newProduct.setDescription("macbook pro");
        newProduct.setPrice(BigDecimal.valueOf(1200.00));
        Product response = productService.updateProduct("1123",newProduct);
        assertEquals(response, newProduct);
    }

    @Test
    public void givenUpdateProductThrowsException() throws ProductServiceException {
        Mockito.when(productRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(ProductServiceException.class, () -> { productService.updateProduct(any(), product); });
    }

    @Test
    public void givenDeleteProductIsSuccessful() throws ProductServiceException {
        String productId = "1123";
        Mockito.when(productRepository.findById(any())).thenReturn(Optional.ofNullable(product));
        productService.deleteProduct(productId);
        verify(productRepository, times(1)).deleteById(productId);
    }

    @Test
    public void givenDeleteProductThrowsException() throws ProductServiceException {
        Mockito.when(productRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(ProductServiceException.class, () -> { productService.deleteProduct(anyString()); });
    }

    @Test
    public void addProduct() {
        when(productRepository.save(any())).thenReturn(product);
        Product response =  productService.addProduct(product);
        verify(productRepository, times(1)).save(any());
        assertEquals(response, product);
    }

    @Test
    public void getAllProducts() {
        List<Product> products = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(products);
        productService.getAllProducts();
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void getProductByIdIsSuccessful() throws ProductServiceException {
        String productId = "1123";
        when(productRepository.findById(anyString())).thenReturn(Optional.ofNullable(product));
        productService.getProductById(productId);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    public void getProductByIdThrowsException() throws ProductServiceException {
        when(productRepository.findById(anyString())).thenReturn(Optional.empty());
        assertThrows(ProductServiceException.class, () -> {productService.getProductById(anyString());});
    }
}