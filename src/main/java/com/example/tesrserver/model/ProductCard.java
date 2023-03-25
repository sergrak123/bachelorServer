package com.example.tesrserver.model;

import com.example.tesrserver.entity.ProductEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductCard implements Serializable {
//    private Long articol;
    private String name;
    private String photoUrl;
    private BigDecimal minPrice;
    private Long minStore;
    private String description;
    private List<CartUnit> cartUnits;

    public ProductCard() {
    }

    public ProductCard(String name, String photoUrl, BigDecimal minPrice, Long minStore, String description, List<CartUnit> cartUnits) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.minPrice = minPrice;
        this.minStore = minStore;
        this.description = description;
        this.cartUnits = cartUnits;
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

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public Long getMinStore() {
        return minStore;
    }

    public void setMinStore(Long minStore) {
        this.minStore = minStore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CartUnit> getCartUnits() {
        return cartUnits;
    }

    public void setCartUnits(List<CartUnit> cartUnits) {
        this.cartUnits = cartUnits;
    }
}
