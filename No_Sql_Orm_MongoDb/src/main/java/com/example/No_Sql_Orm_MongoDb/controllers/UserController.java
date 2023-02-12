package com.example.No_Sql_Orm_MongoDb.controllers;

import com.example.No_Sql_Orm_MongoDb.entities.User;
import com.example.No_Sql_Orm_MongoDb.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
private UserInterface userInterface;



    @PostMapping("")
public User createUser(@RequestBody User user){
        return userInterface.save(user);
    }

    @GetMapping("")
    public List<User> getAllUsers(){
      return userInterface.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getSingleUser(@PathVariable String id){
       return userInterface.findById(id);
    }

    @PutMapping("/{id}")
    public User editUser1(@PathVariable String id, @RequestBody User user) throws Exception{

        if(!userInterface.existsById(id)){
            throw new Exception("User not found");
        }
        return userInterface.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable String id){
        userInterface.deleteById(id);
    }

}
