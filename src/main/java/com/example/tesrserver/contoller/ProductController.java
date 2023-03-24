package com.example.tesrserver.contoller;

import com.example.tesrserver.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //возвращает каталог c объедненными карточками + пагинация/сортировка/фильтрация
    @GetMapping
    public ResponseEntity getAllProducts(){
        try {
            return ResponseEntity.ok().body(productService.getAllProducts());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

//    @PostMapping
//    public ResponseEntity addProduct(@RequestBody Product product){
//        try {
//            return ResponseEntity.ok().body(productService.addProduct(product));
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body("Error");
//        }
//    }

    //возвращает товар для отображения карточки со всеми ценами
    //можно по имени (или артикулу)
//    @GetMapping("/{id}")
//    public ResponseEntity getProduct(@PathVariable Long articol){
//        return ResponseEntity.badRequest().body("Error");
//    }

    //Ex: (/products?name=water)
    //возвращает модель карточки товара
//    @GetMapping("/get")
//    public ResponseEntity getProduct(@RequestParam String name){
//        return ResponseEntity.badRequest().body("Error");
//    }
}
