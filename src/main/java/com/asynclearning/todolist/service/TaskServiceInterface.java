package com.asynclearning.todolist.service;

import java.util.List;

import com.asynclearning.todolist.DTO.TaskRequestDTO;
import com.asynclearning.todolist.domain.Task;

public interface TaskServiceInterface {

    Task createTaskList(TaskRequestDTO taskRequestDTO);

    List<Task> getAllTaskLists();

    Task getTaskListById(Long id);

    void updateTaskList(Long id, TaskRequestDTO taskRequestDTO);

    void deleteTaskList(Long id);

}
