package com.ivoyant.Cassandra.Controller;


import com.ivoyant.Cassandra.Model.Address;
import com.ivoyant.Cassandra.Model.UserData;
import com.ivoyant.Cassandra.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Query;
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

    @PostMapping("/saveAllUser")
    public List<UserData> saveUser(@RequestBody UserData user) {
        cassandraTemplate.insert(user);
        List<UserData> users = cassandraTemplate.select(Query.empty(), UserData.class);
        return users;
    }

    @PostMapping("/user")
    public UserData addUserData(@RequestBody UserData user) {
        cassandraTemplate.insert(user);
        return user;
    }

    @GetMapping("/data/{age}")
    public Object UserDataByAge(@PathVariable int age) {
        String query = "Select * from userData where age =" + age;
        return cassandraTemplate.selectOne(query, UserData.class);
    }

    @GetMapping("/datas/{age}")
    public Object UserDataByAddressAndAge(@PathVariable int age) {
        String query = "Select addressCity,addressCountry,addressLandmark from userData where age=" + age;
        UserData userData = cassandraTemplate.selectOne(query, UserData.class);
        return userData.getAddress();
    }

    @GetMapping("/getAllUsers")
    public List<UserData> getAll() {
        String query = "select * from userData";
        List<UserData> userDataList = cassandraTemplate.select(query, UserData.class);
        return userDataList;
    }

    @GetMapping("/userData/{country}")
    public Object UserDataByAddress(@PathVariable String country) {
        String query = "Select * from userdata where addressCountry='" + country + "'";
        UserData userData = cassandraTemplate.selectOne(query, UserData.class);
        return userData;
    }

    @GetMapping("/userData/address/{city}")
    public Object UserDataByCity(@PathVariable String city) {
        String query = "Select * from userdata where addressCity='" + city + "'";
        UserData userData = cassandraTemplate.selectOne(query, UserData.class);
        return userData;
    }

    @GetMapping("userDataByGender/{gender}")
    public Object UserDataByGender(@PathVariable String gender) {
        String query = "Select * from userdata where gender='" + gender + "'";
        UserData userData = cassandraTemplate.selectOne(query, UserData.class);
        return userData;
    }

    @GetMapping("userDataByName/{name}")
    public Object UserDataByName(@PathVariable String name) {
        String query = "Select * from userData where name='" + name + "'";
        UserData userData = cassandraTemplate.selectOne(query, UserData.class);
        return userData;
    }

    @GetMapping("userDataByCustomisedAge")
    public List<UserData> UserDataByCustomisedAge(@RequestParam int minAge, @RequestParam int maxAge) {
        String query = "SELECT * FROM userData WHERE age <= " + maxAge + " AND age >= " + minAge + " ALLOW FILTERING";
        List<UserData> userDataList = cassandraTemplate.select(query, UserData.class);
        return userDataList;
    }

}
