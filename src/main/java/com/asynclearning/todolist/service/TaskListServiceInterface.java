package com.asynclearning.todolist.service;

import java.util.List;

import com.asynclearning.todolist.DTO.TaskListRequestDTO;
import com.asynclearning.todolist.DTO.TaskListResponseDTO;

public interface TaskListServiceInterface {
    
    TaskListResponseDTO createTaskList(TaskListRequestDTO taskListRequestDTO);

    List<TaskListResponseDTO> getAllTaskLists();

    TaskListResponseDTO getTaskListById(Long id);

    void updateTaskList(Long id, TaskListRequestDTO taskListRequestDTO);

    void deleteTaskList(Long id);

}
