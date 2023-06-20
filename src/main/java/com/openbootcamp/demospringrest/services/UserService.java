package com.openbootcamp.demospringrest.services;
import com.openbootcamp.demospringrest.models.Bootcamper;
import com.openbootcamp.demospringrest.models.User;
import org.jvnet.hk2.annotations.Service;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();


    public void add (User user){
        users.add(user);
    }

    public List<User> getAll() {
        return users;
    }

    public User get(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public boolean remove (Long id) {
        return users.removeIf(user -> user.getId().equals(id));

    }

}
