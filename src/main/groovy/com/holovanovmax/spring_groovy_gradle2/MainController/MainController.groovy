package com.holovanovmax.spring_groovy_gradle2.MainController

import com.holovanovmax.spring_groovy_gradle2.Model.Product
import com.holovanovmax.spring_groovy_gradle2.Repository.ProductRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    private final ProductRepository productRepository

    MainController(ProductRepository productRepository){
        this.productRepository = productRepository
    }


    @GetMapping("/users")
    ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(this.productRepository.findAll())
    }


}
