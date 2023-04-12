package com.holovanovmax.spring_groovy_gradle2.Repository

import com.holovanovmax.spring_groovy_gradle2.Model.Product
import org.springframework.data.mongodb.repository.MongoRepository


interface ProductRepository extends MongoRepository<Product, String> {

}