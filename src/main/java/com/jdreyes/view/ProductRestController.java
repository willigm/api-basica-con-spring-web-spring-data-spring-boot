package com.jdreyes.view;

import com.jdreyes.bussines.ProductService;
import com.jdreyes.modelo.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product/")
public class ProductRestController {
   private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Product>> getall(){
     return  ResponseEntity.ok(productService.getProducts());
 }
 @GetMapping("find/{id}")
 public ResponseEntity <Product> findbyid(@PathVariable int id){
        return  ResponseEntity.ok(productService.buscarbyid(id).orElse(null));
 }

}
