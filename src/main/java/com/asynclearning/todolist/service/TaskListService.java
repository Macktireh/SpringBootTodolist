package com.asynclearning.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asynclearning.todolist.DTO.TaskListRequestDTO;
import com.asynclearning.todolist.DTO.TaskListResponseDTO;
import com.asynclearning.todolist.domain.TaskList;
import com.asynclearning.todolist.gateway.TaskListGatewayInterface;

@Service
public class TaskListService implements TaskListServiceInterface {

    private final TaskListGatewayInterface taskListGatewayInterface;

    public TaskListService(TaskListGatewayInterface taskListGatewayInterface) {

        this.taskListGatewayInterface = taskListGatewayInterface;

    }

    /**
     * Creates a new task list based on the provided TaskListRequestDTO.
     *
     * @param taskListRequestDTO the TaskListRequestDTO containing the details of
     *                           the task list
     * @return the created TaskList
     */
    public TaskListResponseDTO createTaskList(TaskListRequestDTO taskListRequestDTO) {

        return this.domainToDTO(taskListGatewayInterface.createTaskList(taskListRequestDTO.getName()));

    }

    /**
     * Retrieves all task lists.
     *
     * @return A list of TaskListResponseDTO objects representing the task lists.
     */
    public List<TaskListResponseDTO> getAllTaskLists() {

        return taskListGatewayInterface.getAllTaskLists().stream().map((domainTaskList) -> this.domainToDTO(domainTaskList)).toList();

    }

    /**
     * Retrieves a task list by its ID.
     *
     * @param id the ID of the task list
     * @return the task list with the specified ID
     */
    public TaskListResponseDTO getTaskListById(Long id) {

        return this.domainToDTO(taskListGatewayInterface.getTaskListById(id));

    }

    /**
     * Updates a task list.
     *
     * @param id                 the ID of the task list to be updated
     * @param taskListRequestDTO the DTO containing the updated task list
     *                           information
     */
    public void updateTaskList(Long id, TaskListRequestDTO taskListRequestDTO) {

        taskListGatewayInterface.updateTaskList(id, taskListRequestDTO.getName());

    }

    /**
     * Deletes a task list with the specified ID.
     *
     * @param id the ID of the task list to be deleted
     */
    public void deleteTaskList(Long id) {

        taskListGatewayInterface.deleteTaskList(id);

    }

    /**
     * Converts a TaskList domain object to a TaskListResponseDTO object.
     * 
     * @param taskList the TaskList domain object
     * @return the TaskListResponseDTO
     */
    private TaskListResponseDTO domainToDTO(TaskList taskList) {

        return new TaskListResponseDTO(taskList.getId(), taskList.getName(), taskList.getCreatedAt());

    }

}
