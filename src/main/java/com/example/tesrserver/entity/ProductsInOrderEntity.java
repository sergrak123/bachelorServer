package com.example.tesrserver.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_product")
public class ProductsInOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    //change to OrderEntity and 1/m
    private Long orderId;
    private Integer quantity;
    private BigDecimal orderedPrice;

    public ProductsInOrderEntity() {
    }

    public ProductsInOrderEntity(Long orderId, Long productId, Integer quantity, BigDecimal orderedPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderedPrice = orderedPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getOrderedPrice() {
        return orderedPrice;
    }

    public void setOrderedPrice(BigDecimal orderedPrice) {
        this.orderedPrice = orderedPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
