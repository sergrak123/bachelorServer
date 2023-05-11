package com.example.tesrserver.model.order;

import com.example.tesrserver.entity.OrderEntity;
import com.example.tesrserver.entity.ProductsInOrderEntity;

import java.util.List;

public class OrderCard {
//    private OrderEntity orderInfo;
    private List<ProductsInOrderEntity> productsInOrder;

    public OrderCard() {
    }

    public OrderCard(OrderEntity orderInfo, List<ProductsInOrderEntity> productsInOrder) {
//        this.orderInfo = orderInfo;
        this.productsInOrder = productsInOrder;
    }

//    public OrderEntity getOrderInfo() {
//        return orderInfo;
//    }
//
//    public void setOrderInfo(OrderEntity orderInfo) {
//        this.orderInfo = orderInfo;
//    }

    public List<ProductsInOrderEntity> getProductsInOrder() {
        return productsInOrder;
    }

    public void setProductsInOrder(List<ProductsInOrderEntity> productsInOrder) {
        this.productsInOrder = productsInOrder;
    }
}
