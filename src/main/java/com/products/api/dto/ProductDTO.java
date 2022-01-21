package com.products.api.dto;

import com.products.api.entities.Product;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal quantity;
    private BigDecimal value;

    public ProductDTO() {
    }

    public ProductDTO(Long id ,String name, BigDecimal quantity, BigDecimal value) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.value = value;
    }
    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        quantity = product.getQuantity();
        value = product.getValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
