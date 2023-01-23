package com.codeninjas.productservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product {
    @Id
    @Generated
    private String id;

    // @Size(min=2, message = "Name should have at least 2 characters")
    @NotNull(message = "Name is a required field")
    @NotBlank
    private String name;
    private String description;
    private BigDecimal price;
}
