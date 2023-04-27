package com.holovanovmax.spring_groovy_gradle2.Model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
class users {

    @Id
    String id

    String name

    String email

}
