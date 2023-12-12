package com.ivoyant.Cassandra.Controller;


import com.ivoyant.Cassandra.Model.Address;
import com.ivoyant.Cassandra.Model.UserData;
import com.ivoyant.Cassandra.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.web.bind.annotation.*;

import java.beans.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;
    @Autowired
    private CassandraTemplate cassandraTemplate;
    @PostMapping("/getAllUser")
    public List<UserData>  saveUser(@RequestBody UserData user) {
        List<UserData> users = new ArrayList<>();
       return repository.saveAll(users);
    }

    @GetMapping("/getAllUsers")
    public List<UserData>getUsers(){

        return repository.findAll();
    }

    @GetMapping("/getUserByAge/{age}")
    public List<UserData>getUserFilterByAge(@PathVariable int age){
       return repository.findByAgeGreaterThan(age);
    }
    @PostMapping("/user")
    public UserData addUserData(@RequestBody UserData user){
        cassandraTemplate.insert(user);
        return user;
    }
    @GetMapping("/data/{age}")
    public Object UserDataByAge(@PathVariable int age){
        String query = "Select * from user where age ="+age;
        return cassandraTemplate.selectOne(query,UserData.class);
    }
    @GetMapping("/datas/{age}")
    public Object UserDataByAddress(@PathVariable int age){
        String query="Select addresscity,addressCountry,addresslandmark from userdata where age="+age;
        UserData userData=cassandraTemplate.selectOne(query, UserData.class);
        return userData.getAddress();
    }

}
