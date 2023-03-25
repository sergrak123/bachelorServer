package com.example.tesrserver.model;

import java.math.BigDecimal;

public class CartUnit {
    private Long storeId;
    private BigDecimal price;

    public CartUnit() {
    }

    public CartUnit(Long storeId, BigDecimal price) {
        this.storeId = storeId;
        this.price = price;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
