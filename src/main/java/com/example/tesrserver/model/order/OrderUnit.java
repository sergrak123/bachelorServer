package com.example.tesrserver.model.order;

import java.math.BigDecimal;

public class OrderUnit {
//    private Long productId;
    private String name;
    private Integer quantity;
//    private BigDecimal price;

    public OrderUnit() {
    }

    public OrderUnit(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
