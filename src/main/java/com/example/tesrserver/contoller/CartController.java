package com.example.tesrserver.contoller;

import com.example.tesrserver.model.cart.CartUnit;
import com.example.tesrserver.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //    @GetMapping()
    @PostMapping()
    public ResponseEntity getCart(@RequestBody List<CartUnit> cartUnits) {
//        System.out.println(cartUnits);
//        cartUnits.stream().forEach((item) -> System.out.println(item.getCount()));
        try {
            return ResponseEntity.ok().body(cartService.getCart(cartUnits));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Cart error");
        }
    }

}
