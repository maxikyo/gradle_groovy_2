package com.holovanovmax.spring_groovy_gradle2.Repository

import com.holovanovmax.spring_groovy_gradle2.Model.users
import org.springframework.data.mongodb.repository.MongoRepository


interface usersRepository extends MongoRepository<users, String>{

}