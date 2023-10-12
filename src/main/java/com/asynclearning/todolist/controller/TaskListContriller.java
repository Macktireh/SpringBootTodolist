package com.asynclearning.todolist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.asynclearning.todolist.DTO.TaskListRequestDTO;
import com.asynclearning.todolist.DTO.TaskListResponseDTO;
import com.asynclearning.todolist.service.TaskListServiceInterface;

@RestController
@RequestMapping("/tasklist")
public class TaskListContriller {

    private final TaskListServiceInterface taskListServiceInterface;

    public TaskListContriller(TaskListServiceInterface taskListServiceInterface) {
        this.taskListServiceInterface = taskListServiceInterface;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public TaskListResponseDTO create(@RequestBody TaskListRequestDTO taskListRequestDTO) {
        return taskListServiceInterface.createTaskList(taskListRequestDTO);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<TaskListResponseDTO> getAll() {
        return taskListServiceInterface.getAllTaskLists();
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public TaskListResponseDTO getById(@PathVariable Long id) {
        return taskListServiceInterface.getTaskListById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void update(@PathVariable Long id, @RequestBody TaskListRequestDTO taskListRequestDTO) {
        taskListServiceInterface.updateTaskList(id, taskListRequestDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        taskListServiceInterface.deleteTaskList(id);
    }

}
