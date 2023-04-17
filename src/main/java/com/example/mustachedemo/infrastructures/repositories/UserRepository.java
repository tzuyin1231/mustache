package com.example.mustachedemo.infrastructures.repositories;

import com.example.mustachedemo.model.entities.UserEntitites;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntitites, Long> {
}