package com.holovanovmax.spring_groovy_gradle2.mainController


import com.holovanovmax.spring_groovy_gradle2.Model.users
import com.holovanovmax.spring_groovy_gradle2.Repository.usersRepository
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
//class controller {
//
//
//    private final usersRepository productRepository
//
//    controller(usersRepository productRepository) {
//        this.productRepository = productRepository
//    }
//
//
////    @GetMapping("/users")
////    ResponseEntity<List<users>> getAllProducts() {
////        return ResponseEntity.ok(this.productRepository.findAll())
////    }
//
//
//    @GetMapping("/users")
//    List<users> findProducts() {
//        return productRepository.findAll()
//    }
//
//    @PostMapping("/users")
//    ResponseEntity<users> createProduct(@RequestBody ProductRequest productRequest) {
//        users product = new users()
//
//        return ResponseEntity.status(201).body(this.productRepository.save(product))
//
//    }
//
//    @GetMapping("/users/{id}")
//    ResponseEntity getProductById(@PathVariable String id) {
//        Optional<users> product = this.productRepository.findById(id)
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
//        Optional<users> product = this.productRepository.findById(id)
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
class controller {

    @Autowired
    private final usersRepository productRepository;

    @GetMapping("/users")
    List<users> findProduct() {
        return productRepository.findAll()
    }

    @GetMapping("/users/{usersId}")
    users findProduct(@PathVariable final String usersId) {
        return productRepository.findById(usersId).orElseGet(users::new)
    }

    @PostMapping("/users")
    void addUsers(@RequestBody final List<users> products){
        productRepository.saveAll(products)
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity deleteProductById(@PathVariable String id) {
        Optional<users> product = this.productRepository.findById(id)

        if (product.isPresent()) {
            this.productRepository.deleteById(id)
            return ResponseEntity.ok("Done")
        } else {
            log.warn('user with id ' + id + ' not found! And did not deleted')
            return new ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
