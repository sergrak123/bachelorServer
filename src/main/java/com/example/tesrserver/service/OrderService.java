package com.example.tesrserver.service;

import com.example.tesrserver.entity.*;
import com.example.tesrserver.exeptions.NotFoundException;
import com.example.tesrserver.model.cart.Cart;
import com.example.tesrserver.model.order.Order;
import com.example.tesrserver.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final StoreRepo storeRepo;
    private final ProductsInOrderRepo productsInOrderRepo;
    private final ProductRepo productRepo;


    public OrderService(OrderRepo orderRepo, UserRepo userRepo, StoreRepo storeRepo, ProductsInOrderRepo productsInOrderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.storeRepo = storeRepo;
        this.productsInOrderRepo = productsInOrderRepo;
        this.productRepo = productRepo;
    }

    public OrderEntity createOrder(Order order) throws NotFoundException {
        UserEntity user = userRepo.findById(order.getUserId())
                .orElseThrow(() -> new NotFoundException("Пользователь по id:{0} не найден", order.getUserId()));
        StoreEntity store = storeRepo.findById(order.getStoreId())
                .orElseThrow(() -> new NotFoundException("Магазин по id:{0} не найден", order.getStoreId()));
        System.out.println(order);

        OrderEntity orderEntity = new OrderEntity(user, store, LocalDateTime.now(), order.getAmount());
        OrderEntity savedOrder = orderRepo.save(orderEntity);
        System.out.println("created");

        for (Cart cart : order.getCart()) {
            ProductsInOrderEntity productsInOrder = new ProductsInOrderEntity(
                    savedOrder.getId(),
                    cart.getProductId(),
                    cart.getQuantity(),
                    cart.getPrice()
            );
            productsInOrderRepo.save(productsInOrder);
        }

        return savedOrder;
    }

    public List<Order> getAllOrders(Long userId) {
        List<Order> orderCards = new ArrayList<>();

        UserEntity user = userRepo.findById(userId).get();
        List<OrderEntity> orders = orderRepo.findAllByUser(user);
        for (OrderEntity order : orders) {
            List<ProductsInOrderEntity> productsInOrder = productsInOrderRepo.findAllByOrderId(order.getId());
            List<Cart> cartUnit = new ArrayList<>();
            for (ProductsInOrderEntity product : productsInOrder) {
                ProductEntity productEntity = productRepo.findById(product.getProductId()).get();
                cartUnit.add(new Cart(
                        productEntity.getId(),
                        productEntity.getStore().getId(),
                        product.getQuantity(),
                        product.getOrderedPrice(),
                        productEntity.getName(),
                        productEntity.getPhotoUrl()
                ));
            }
            orderCards.add(new Order(
                    user.getId(),
                    order.getId(),
                    order.getStore().getId(),
                    cartUnit,
                    order.getTotalPrice(),
                    order.getOrderTime()));
        }
        return orderCards;
    }
}
