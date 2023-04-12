package com.holovanovmax.spring_groovy_gradle2.Model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
class Product {

    @Id
    private String id

    private String name

    private String email

}
