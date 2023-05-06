package com.example.tesrserver.service;

import com.example.tesrserver.entity.OrderEntity;
import com.example.tesrserver.entity.ProductsInOrderEntity;
import com.example.tesrserver.entity.StoreEntity;
import com.example.tesrserver.entity.UserEntity;
import com.example.tesrserver.exeptions.NotFoundException;
import com.example.tesrserver.model.cart.Cart;
import com.example.tesrserver.model.order.Order;
import com.example.tesrserver.repository.OrderRepo;
import com.example.tesrserver.repository.ProductsInOrderRepo;
import com.example.tesrserver.repository.StoreRepo;
import com.example.tesrserver.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final StoreRepo storeRepo;
    private final ProductsInOrderRepo productsInOrderRepo;


    public OrderService(OrderRepo orderRepo, UserRepo userRepo, StoreRepo storeRepo, ProductsInOrderRepo productsInOrderRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.storeRepo = storeRepo;
        this.productsInOrderRepo = productsInOrderRepo;
    }

    public OrderEntity createOrder(Order order) throws NotFoundException {
        UserEntity user = userRepo.findById(order.getUserId())
                .orElseThrow(() -> new NotFoundException("Пользователь по id:{0} не найден", order.getUserId()));
        StoreEntity store = storeRepo.findById(order.getStoreId())
                .orElseThrow(() -> new NotFoundException("Магазин по id:{0} не найден", order.getStoreId()));
        System.out.println(order);

        OrderEntity orderEntity = new OrderEntity(user, store, LocalDateTime.now(), order.getAmount());
        System.out.println("created");
        OrderEntity savedOrder = orderRepo.save(orderEntity);

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
}
