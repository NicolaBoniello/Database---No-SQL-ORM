package com.example.No_Sql_Orm_MongoDb.interfaces;

import com.example.No_Sql_Orm_MongoDb.entities.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInterface extends MongoRepository<User, String> {
}
