package com.example.tesrserver.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderTime;
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreEntity store;

    public OrderEntity() {
    }

    public OrderEntity(UserEntity user, StoreEntity store, LocalDateTime orderTime, BigDecimal totalPrice) {
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.user = user;
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                ", store=" + store +
                '}';
    }
}