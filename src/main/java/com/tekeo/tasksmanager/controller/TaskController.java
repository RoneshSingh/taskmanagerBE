package com.tekeo.tasksmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekeo.tasksmanager.model.Task;
import com.tekeo.tasksmanager.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/allTask")
    public List<Task> getTask() {
        return service.getAllTasks();
    }

    @PostMapping("/addTask")
    public Task postTask(@RequestBody Task request) {
        return service.postTask(request);
    }

    @PutMapping("/editTask/{id}")
    public Task editTask(@RequestBody Task request, @PathVariable("id") Long id) {
        return service.editTask(id, request);
    }

    @DeleteMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        return service.deleteTask(id);
    }

}
