package com.example.tesrserver.contoller;

import com.example.tesrserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity getAllProducts(){
        try {
            return ResponseEntity.ok().body(productService.getAllProducts());
//            Map<String, Object> response = new HashMap<>();
//            response.put("message", "Test data");
//            response.put("number", 1)
//            return ResponseEntity.ok(response);
//            return ResponseEntity.ok().body(userService.getOne(id));
//        }catch (UserNotFoundExeption e){
//            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
