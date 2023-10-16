package com.asynclearning.todolist.service;

import java.util.List;

import com.asynclearning.todolist.DTO.LabelDTO;
import com.asynclearning.todolist.DTO.TaskRequestDTO;
import com.asynclearning.todolist.DTO.TaskResponseDTO;

public interface TaskServiceInterface {

    TaskResponseDTO createTaskList(TaskRequestDTO taskRequestDTO);

    List<TaskResponseDTO> getAllTaskLists();
    
    TaskResponseDTO getTaskListById(Long id);
    
    void updateTaskList(Long id, TaskRequestDTO taskRequestDTO);
    
    void deleteTaskList(Long id);
    
    LabelDTO createLabel(LabelDTO labelDTO);
    
    List<LabelDTO> getAllLabels();

    void addLabelToTask(Long taskId, String name);

}
