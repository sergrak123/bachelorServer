package com.example.tesrserver.model.cart;

import java.math.BigDecimal;

public class CartUnit {
    private Long id;
    private Long storeId;
    private Integer count;

    public CartUnit() {
    }

    public CartUnit(Long id, Long storeId, Integer count) {
        this.id = id;
        this.storeId = storeId;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
