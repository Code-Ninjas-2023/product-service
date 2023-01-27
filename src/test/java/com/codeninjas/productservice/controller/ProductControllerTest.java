package com.codeninjas.productservice.controller;

import com.codeninjas.productservice.domain.Product;
import com.codeninjas.productservice.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.math.BigDecimal;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
class ProductControllerTest {

    @Autowired
    MockMvc mock;

    @MockBean
    ProductService productService;

    @Test
    public void testGetCustomerById() throws Exception {
        Mockito.when(productService.getProductById("1213")).thenReturn(new Product("1213", "laptop", "macbook", new BigDecimal(1200.99)));
        mock.perform(MockMvcRequestBuilders.get("v1/products/1213"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1213"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("laptop"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("macbook"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("1200"))
        ;}

    @Test
    public void testDeleteCustomerById() throws Exception {
        mock.perform(MockMvcRequestBuilders.delete("{id}",1213))
                .andExpect(status().isOk());
        verify(productService, times(1)).deleteProduct("1213");
    }

    @Test
    public void testAddCustomer() throws Exception {
        Product product = new Product("1213", "laptop", "macbook", "122");
        mock.perform(MockMvcRequestBuilders.post("/")
                        .content(asJsonString(product))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(productService, times(1)).addProduct(product);
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testUpdateProduct() throws Exception {
        Product product = new Product("1213", "laptop", "macbook", "1200");
        mock.perform(MockMvcRequestBuilders.put("/")
                        .content(asJsonString(product))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(productService, times(1)).updateProduct("1213", product);
    }


}