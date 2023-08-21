package com.tekeo.tasksmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tekeo.tasksmanager.model.Task;
import com.tekeo.tasksmanager.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
	User findByUserName(String userName);
	boolean existsByUserName(String userName);
	User findByTasksContaining(Task task);	

}
