package com.asynclearning.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asynclearning.todolist.DTO.TaskRequestDTO;
import com.asynclearning.todolist.domain.Task;
import com.asynclearning.todolist.gateway.TaskGatewayInterface;

@Service
public class TaskService implements TaskServiceInterface {

    private final TaskGatewayInterface taskGatewayInterface;

    public TaskService(TaskGatewayInterface taskGatewayInterface) {
        this.taskGatewayInterface = taskGatewayInterface;
    }

    /**
     * Creates a task list based on the provided task request DTO.
     *
     * @param taskRequestDTO the task request DTO containing the necessary
     *                       information to create the task list
     * @return the created task list
     */
    @Override
    public Task createTaskList(TaskRequestDTO taskRequestDTO) {
        return this.taskGatewayInterface.createTaskList(DTOToDomain(taskRequestDTO));
    }

    /**
     * Retrieve all task lists.
     *
     * @return a list of task lists
     */
    @Override
    public List<Task> getAllTaskLists() {
        return this.taskGatewayInterface.getAllTaskLists();
    }

    /**
     * Retrieves a task from the task list by its ID.
     *
     * @param id the ID of the task to retrieve
     * @return the task corresponding to the given ID, or null if no task is found
     */
    @Override
    public Task getTaskListById(Long id) {
        return this.taskGatewayInterface.getTaskListById(id);
    }

    /**
     * Updates the task list with the given ID using the provided task request DTO.
     *
     * @param id             the ID of the task list to update
     * @param taskRequestDTO the task request DTO containing the updated task list
     *                       information
     */
    @Override
    public void updateTaskList(Long id, TaskRequestDTO taskRequestDTO) {
        this.taskGatewayInterface.updateTaskList(id, DTOToDomain(taskRequestDTO));
    }

    /**
     * Deletes a task list with the specified ID.
     *
     * @param id the ID of the task list to be deleted
     */
    @Override
    public void deleteTaskList(Long id) {
        this.taskGatewayInterface.deleteTaskList(id);
    }

    /**
     * Converts a TaskRequestDTO object to a Task object.
     *
     * @param taskRequestDTO the TaskRequestDTO object to be converted
     * @return the converted Task object
     */
    private Task DTOToDomain(TaskRequestDTO taskRequestDTO) {
        return new Task(
                taskRequestDTO.getTitle(),
                taskRequestDTO.getDescription(),
                taskRequestDTO.getDueDate(),
                taskRequestDTO.getStatus(),
                taskRequestDTO.getPriority(),
                taskRequestDTO.getTaskList(),
                taskRequestDTO.getUpdatedAt(),
                taskRequestDTO.getLabels());
    }

}
