package com.tekeo.tasksmanager.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tekeo.tasksmanager.model.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findByUserName(String userName);

}
