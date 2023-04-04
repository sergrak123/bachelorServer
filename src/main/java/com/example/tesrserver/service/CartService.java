package com.example.tesrserver.service;

import com.example.tesrserver.entity.ProductEntity;
import com.example.tesrserver.model.CartUnit;
import com.example.tesrserver.model.OrderUnit;
import com.example.tesrserver.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartService {

    private final ProductRepo productRepo;

    public CartService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    //просчет стоимости корзины по id и картюнит
    public BigDecimal getCartTotalPrice(List<OrderUnit> orderUnits, Long storeId) {
        BigDecimal totalPrice = BigDecimal.valueOf(0);

        for (OrderUnit prod : orderUnits) {

            //найти товар по name/articol и по storeID
            ProductEntity product = productRepo.findByNameAndStore_Id(prod.getName(), storeId);
            BigDecimal itemCost = product.getPrice().multiply(BigDecimal.valueOf(prod.getQuantity()));
            totalPrice.add(itemCost);
        }

        return totalPrice;

    }

    //сначала находим мин магазин по минимальной корзине
    public void findOptimalStore(List<CartUnit> cartUnits) {

        //поиск всех магазинов
        //пройтис по магазинам и помссчитать сумму и добавить в хм магазин и цена
        //вернуст магазин
    }

    //возвращаем список с картюнитами с мин ценой магазин и общую сумму на основе магазина
    public void getOptimalCart() {
        //по id вернуть список товаров с текущими ценами и тотал

    }
}
