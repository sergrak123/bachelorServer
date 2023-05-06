package com.example.tesrserver.model.product;

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
    private List<ProdUnit> prodUnits;

    public ProductCard() {
    }

    public ProductCard(String name, String photoUrl, BigDecimal minPrice, Long minStore, String description, List<ProdUnit> prodUnits) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.minPrice = minPrice;
        this.minStore = minStore;
        this.description = description;
        this.prodUnits = prodUnits;
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

    public List<ProdUnit> getCartUnits() {
        return prodUnits;
    }

    public void setCartUnits(List<ProdUnit> prodUnits) {
        this.prodUnits = prodUnits;
    }
}
