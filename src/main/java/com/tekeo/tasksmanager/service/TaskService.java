package com.tekeo.tasksmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekeo.tasksmanager.model.Task;
import com.tekeo.tasksmanager.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task postTask(Task request) {
        return repository.save(request);
    }

    public Task editTask(Long id, Task request) {
        Task editedTask = repository.findById(id).orElse(null);

        if (editedTask != null) {
            editedTask.setTitle(request.getTitle());
            editedTask.setDate(request.getDate());
            editedTask.setDescription(request.getDescription());
            editedTask.setCompleted(request.getCompleted());

        }
        return repository.save(editedTask);
    }

    public String deleteTask(Long id) {
        repository.deleteById(id);
        return "Task Deleted";
    }

}
