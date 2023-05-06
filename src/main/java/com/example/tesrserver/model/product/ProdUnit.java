package com.example.tesrserver.model.product;

import java.math.BigDecimal;

public class ProdUnit {
    private Long productId;
    private Long storeId;
    private BigDecimal price;

    public ProdUnit() {
    }

    public ProdUnit(Long productId, Long storeId, BigDecimal price) {
        this.productId = productId;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
