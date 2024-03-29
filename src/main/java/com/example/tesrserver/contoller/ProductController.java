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
    public ResponseEntity getAllProducts() {
        try {
            return ResponseEntity.ok().body(productService.getAllProducts());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/custom")
    public ResponseEntity getAllProductsCustom(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                               @RequestParam(value = "size", defaultValue = "4") Integer size,
                                               @RequestParam(value = "category", defaultValue = "all") String category
    ) {
        try {
            return ResponseEntity.ok().body(productService.getAllProductsCustom(page, size, category));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }


    @GetMapping("/get")
    public ResponseEntity getProductCard(@RequestParam String name) {
        try {
            return ResponseEntity.ok().body(productService.getProductCard(name));
        } catch (Exception e) {
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
