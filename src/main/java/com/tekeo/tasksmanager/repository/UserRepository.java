package com.tekeo.tasksmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tekeo.tasksmanager.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
