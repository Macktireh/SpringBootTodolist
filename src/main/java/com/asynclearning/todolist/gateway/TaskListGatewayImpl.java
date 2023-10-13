package com.asynclearning.todolist.gateway;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asynclearning.todolist.domain.TaskList;
import com.asynclearning.todolist.entity.TaskListEntity;
import com.asynclearning.todolist.repository.TaskListRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskListGatewayImpl implements TaskListGatewayInterface {

    private final TaskListRepository taskListRepository;

    public TaskListGatewayImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    /**
     * Creates a new task list with the given name.
     *
     * @param name the name of the task list
     * @return the created task list
     */
    @Override
    public TaskList createTaskList(String name) {
        if (this.taskListRepository.findByName(name).isPresent()) {
            throw new EntityExistsException("Task list already exists");
        }
        TaskListEntity taskListEntity = this.taskListRepository.save(domainToEntity(name));
        return entityToDomain(taskListEntity);
    }

    /**
     * Retrieves all task lists.
     *
     * @return a list of TaskList objects representing all task lists
     */
    public List<TaskList> getAllTaskLists() {
        return this.taskListRepository.findAll().stream().map((taskListEntity) -> entityToDomain(taskListEntity))
                .toList();
    }

    /**
     * Retrieves a TaskList object by its ID.
     *
     * @param id the ID of the TaskList
     * @return the TaskList object with the specified ID
     */
    public TaskList getTaskListById(Long id) {
        TaskListEntity taskListEntity = this.taskListRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task list not found"));
        return entityToDomain(taskListEntity);
    }

    /**
     * Retrieves a TaskList object by its ID.
     *
     * @param id the ID of the TaskList
     * @return the TaskList object with the specified ID
     */
    public TaskListEntity getById(Long id) {
        return this.taskListRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task list not found"));
    }

    /**
     * Updates a task list with the given id by changing its name.
     *
     * @param id   the id of the task list to be updated
     * @param name the new name for the task list
     */
    public void updateTaskList(Long id, String name) {
        TaskListEntity taskListEntity = this.taskListRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task list not found"));
        taskListEntity.setName(name);
        this.taskListRepository.save(taskListEntity);
    }

    /**
     * Deletes a task list with the given ID.
     *
     * @param id the ID of the task list to be deleted
     */
    public void deleteTaskList(Long id) {
        TaskListEntity taskListEntity = this.taskListRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task list not found"));
        this.taskListRepository.delete(taskListEntity);
    }

    /**
     * Converts a domain object to an entity object.
     *
     * @param name the name of the domain object
     * @return the converted entity object
     */
    private TaskListEntity domainToEntity(String name) {
        return new TaskListEntity(name, LocalDateTime.now());
    }

    /**
     * Converts an entity object to a domain object.
     *
     * @param taskListEntity the TaskListEntity object to convert
     * @return the converted TaskList object
     */
    public TaskList entityToDomain(TaskListEntity taskListEntity) {
        return new TaskList(taskListEntity.getId(), taskListEntity.getName(), taskListEntity.getCreatedAt());
    }
}
