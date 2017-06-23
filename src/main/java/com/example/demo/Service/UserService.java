package com.example.demo.Service;

import com.example.demo.Model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vadyan on 6/23/2017.
 */
@Service
public class UserService {

    private Map<String, User> users ;

    @PostConstruct
    private void loadUser() {
        users = new HashMap<>() ;

        users.put("1", new User("Tom", 20));
        users.put("2", new User("Jerry", 40));
        users.put("3", new User("Jason", 50));
    }

    public User findById(String id) {
        return users.get(id) ;
    }

}
