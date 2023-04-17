package com.example.mustachedemo.Service;

import com.example.mustachedemo.infrastructures.repositories.UserRepository;
import com.example.mustachedemo.model.entities.UserEntitites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<UserEntitites> getAllUsers() {
        List<UserEntitites> result = (List<UserEntitites>) repository.findAll();
        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<UserEntitites>();
        }
    }
}
