package com.ivoyant.Cassandra.Controller;
import com.ivoyant.Cassandra.Model.UserData;
import com.ivoyant.Cassandra.Repository.UserRepository;
import com.ivoyant.Cassandra.StringQuery.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.web.bind.annotation.*;
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
        String query = UserQuery.SELECT_ADDRESS_QUERY + age;
        UserData userData = cassandraTemplate.selectOne(query, UserData.class);
        return userData.getAddress();
    }

    @GetMapping("/getAllUsers")
    public List<UserData> getAll() {
        String query = UserQuery.SELECT_ALL_USERS_QUERY;
        List<UserData> userDataList = cassandraTemplate.select(query, UserData.class);
        return userDataList;
    }

    @GetMapping("/userData/{country}")
    public Object UserDataByAddress(@PathVariable String country) {
        String query = UserQuery.SELECT_USER_BY_COUNTRY_QUERY + country + "'";
        UserData userData = cassandraTemplate.selectOne(query, UserData.class);
        return userData;
    }

    @GetMapping("/userData/address/{city}")
    public Object UserDataByCity(@PathVariable String city) {
        String query = UserQuery.SELECT_USER_BY_CITY_QUERY + city + "'";
        UserData userData = cassandraTemplate.selectOne(query, UserData.class);
        return userData;
    }

    @GetMapping("userDataByGender/{gender}")
    public Object UserDataByGender(@PathVariable String gender) {
        String query = UserQuery.SELECT_USER_BY_GENDER_QUERY + gender + "'";
        UserData userData = cassandraTemplate.selectOne(query, UserData.class);
        return userData;
    }

    @GetMapping("userDataByName/{name}")
    public Object UserDataByName(@PathVariable String name) {
        String query = UserQuery.SELECT_USER_BY_NAME_QUERY + name + "'";
        UserData userData = cassandraTemplate.selectOne(query, UserData.class);
        return userData;
    }

    @GetMapping("userDataByCustomisedAge")
    public List<UserData> UserDataByCustomisedAge(@RequestParam int minAge, @RequestParam int maxAge) {
        String query = UserQuery.SELECT_USER_BY_CUSTOMISED_AGE_QUERY + maxAge + UserQuery.AGE_FILTER_CONDITION +
                minAge + UserQuery.ALLOW_FILTERING_SUFFIX;
        List<UserData> userDataList = cassandraTemplate.select(query, UserData.class);
        return userDataList;
    }

}
