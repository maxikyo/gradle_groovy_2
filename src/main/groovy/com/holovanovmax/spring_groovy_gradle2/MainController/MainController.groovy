package com.holovanovmax.spring_groovy_gradle2.MainController

import com.holovanovmax.spring_groovy_gradle2.Model.Product
import com.holovanovmax.spring_groovy_gradle2.Repository.ProductRepository
import com.holovanovmax.spring_groovy_gradle2.Request.ProductRequest
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

//first variant of controller
//@Slf4j
//@RestController
//class MainController {
//
//
//    private final ProductRepository productRepository
//
//    MainController(ProductRepository productRepository) {
//        this.productRepository = productRepository
//    }
//
//
////    @GetMapping("/users")
////    ResponseEntity<List<Product>> getAllProducts() {
////        return ResponseEntity.ok(this.productRepository.findAll())
////    }
//
//
//    @GetMapping("/users")
//    List<Product> findProducts() {
//        return productRepository.findAll()
//    }
//
//    @PostMapping("/users")
//    ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
//        Product product = new Product()
//
//        return ResponseEntity.status(201).body(this.productRepository.save(product))
//
//    }
//
//    @GetMapping("/users/{id}")
//    ResponseEntity getProductById(@PathVariable String id) {
//        Optional<Product> product = this.productRepository.findById(id)
//
//        if (product.isPresent()) {
//            return ResponseEntity.ok(product.get())
//        } else {
//            return new ResponseEntity(HttpStatus.NOT_FOUND)
//        }
//    }
//
//    @DeleteMapping("/users/{id}")
//    ResponseEntity deleteProductById(@PathVariable String id) {
//        Optional<Product> product = this.productRepository.findById(id)
//
//        if (product.isPresent()) {
//            this.productRepository.deleteById(id)
//            return ResponseEntity.ok("Done")
//        } else {
//            log.warn('user with id ' + id + ' not found! And did not deleted')
//            return new ResponseEntity(HttpStatus.NOT_FOUND)
//        }
//    }
//}

@Slf4j
@RestController
class MainController {

    @Autowired
    private final ProductRepository productRepository;

    @GetMapping("/users")
    List<Product> findProduct() {
        return productRepository.findAll()
    }

    @GetMapping("/users/{usersId}")
    Product findProduct(@PathVariable final String usersId) {
        return productRepository.findById(usersId).orElseGet(Product::new)
    }

    @PostMapping("/users")
    void addUsers(@RequestBody final List<Product> products){
        productRepository.saveAll(products)
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity deleteProductById(@PathVariable String id) {
        Optional<Product> product = this.productRepository.findById(id)

        if (product.isPresent()) {
            this.productRepository.deleteById(id)
            return ResponseEntity.ok("Done")
        } else {
            log.warn('user with id ' + id + ' not found! And did not deleted')
            return new ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
