package com.example.tesrserver.model.order;

import com.example.tesrserver.model.cart.Cart;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long userId;
    private Long orderId;
    private Long storeId;
    private List<Cart> cart;
    private BigDecimal amount;
    private LocalDateTime orderTime;

    public Order() {
    }

    public Order(Long userId, Long orderId, Long storeId, List<Cart> cart, BigDecimal amount, LocalDateTime orderTime) {
        this.userId = userId;
        this.orderId = orderId;
        this.storeId = storeId;
        this.cart = cart;
        this.amount = amount;
        this.orderTime = orderTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId=" + userId +
                ", storeId=" + storeId +
                ", cart=" + cart +
                ", amount=" + amount +
                '}';
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
