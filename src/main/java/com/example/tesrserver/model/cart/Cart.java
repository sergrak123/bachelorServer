package com.example.tesrserver.model.cart;

import java.math.BigDecimal;

public class Cart {
    private Long productId;
    private Long storeId;
    private Integer quantity;
    private BigDecimal price;
    private String name;
    private String photoUrl;

    public Cart() {
    }

    public Cart(Long productId, Long storeId, Integer quantity, BigDecimal price, String name, String photoUrl) {
        this.productId = productId;
        this.storeId = storeId;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productId=" + productId +
                ", storeId=" + storeId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
