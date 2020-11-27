package com.MappyVoisins.MapyVoisin.Repository;

import com.MappyVoisins.MapyVoisin.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List <User> findAll();
    Optional<User> findById(String id);
}
