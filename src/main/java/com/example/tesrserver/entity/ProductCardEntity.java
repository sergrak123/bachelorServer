package com.example.tesrserver.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product_card")
public class ProductCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private String photoUrl;

    private BigDecimal minPrice;
    private Long prod_id;
    private Long minStore;

    public ProductCardEntity() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Long getProd_id() {
        return prod_id;
    }

    public void setProd_id(Long prod_id) {
        this.prod_id = prod_id;
    }

    public Long getMinStore() {
        return minStore;
    }

    public void setMinStore(Long minStore) {
        this.minStore = minStore;
    }
}
