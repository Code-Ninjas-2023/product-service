package com.codeninjas.productservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Name is a required field")
    @NotBlank(message = "name shouldn't be blank")
    private String name;

    private String description;

    @NotNull(message = "price is a required field")
    private BigDecimal price;
}
