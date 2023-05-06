package com.example.tesrserver.service;

import com.example.tesrserver.entity.ProductEntity;
import com.example.tesrserver.exeptions.NotFoundException;
import com.example.tesrserver.model.cart.Cart;
import com.example.tesrserver.model.cart.CartUnit;
import com.example.tesrserver.model.order.OrderUnit;
import com.example.tesrserver.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CartService {

    private final ProductRepo productRepo;
    private final ProductService productService;

    public CartService(ProductRepo productRepo, ProductService productService) {
        this.productRepo = productRepo;
        this.productService = productService;
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

    //    public List<Cart> getCart(List<CartUnit> cartUnits) throws NotFoundException {
//        List<Cart> cartList = new ArrayList<>();
//        for (CartUnit unit: cartUnits) {
//            ProductEntity product = productService.getProduct(unit.getId());
//            Cart cartElement = new Cart(
//                    product.getId(),
//                    product.getStore().getId(),
//                    unit.getCount(),
//                    product.getPrice(),
//                    product.getName(),
//                    product.getPhotoUrl()
//            );
//            cartList.add(cartElement);
//        }
//        return cartList;
//    }
    public HashMap<Long, ArrayList<Cart>> getCart(List<CartUnit> cartUnits) throws NotFoundException {
//        List<Cart> cartList = new ArrayList<>();
        HashMap<Long, ArrayList<Cart>> mappedCart = new HashMap<>();
        for (CartUnit unit : cartUnits) {
            ProductEntity product = productService.getProduct(unit.getId());
            Cart cartElement = new Cart(
                    product.getId(),
                    product.getStore().getId(),
                    unit.getCount(),
                    product.getPrice(),
                    product.getName(),
                    product.getPhotoUrl()
            );
            if(mappedCart.containsKey(cartElement.getStoreId())){
                mappedCart.get(cartElement.getStoreId()).add(cartElement);
            }
            else{
                mappedCart.put(cartElement.getStoreId(), new ArrayList<>(List.of(cartElement)));
            }
        }
        return mappedCart;
    }
}
