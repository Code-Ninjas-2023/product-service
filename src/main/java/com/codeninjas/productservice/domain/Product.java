package com.codeninjas.productservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product {
    @Id
    @Generated
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
