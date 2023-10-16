package com.asynclearning.todolist.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asynclearning.todolist.DTO.LabelDTO;
import com.asynclearning.todolist.DTO.TaskListResponseDTO;
import com.asynclearning.todolist.DTO.TaskRequestDTO;
import com.asynclearning.todolist.DTO.TaskResponseDTO;
import com.asynclearning.todolist.domain.Label;
import com.asynclearning.todolist.domain.Task;
import com.asynclearning.todolist.domain.TaskList;
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
    public TaskResponseDTO createTaskList(TaskRequestDTO taskRequestDTO) {

        return this.domainToDTO(this.taskGatewayInterface.createTaskList(DTOToDomain(taskRequestDTO)));

    }

    /**
     * Retrieve all task lists.
     *
     * @return a list of task lists
     */
    @Override
    public List<TaskResponseDTO> getAllTaskLists() {

        return this.taskGatewayInterface.getAllTaskLists().stream().map((task) -> domainToDTO(task)).toList();

    }

    /**
     * Retrieves a task from the task list by its ID.
     *
     * @param id the ID of the task to retrieve
     * @return the task corresponding to the given ID, or null if no task is found
     */
    @Override
    public TaskResponseDTO getTaskListById(Long id) {

        return this.domainToDTO(this.taskGatewayInterface.getTaskListById(id));

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
     * Creates a new label.
     *
     * @param  labelDTO  the label data transfer object
     * @return           the created label data transfer object
     */
    @Override
    public LabelDTO createLabel(LabelDTO labelDTO) {

        Label label = this.taskGatewayInterface.createLabel(new Label(labelDTO.getName(), labelDTO.getColor()));

        return new LabelDTO(label.getName(), label.getColor());

    }


    /**
     * Retrieves all labels.
     *
     * @return A list of LabelDTO objects representing the labels.
     */
    @Override
    public List<LabelDTO> getAllLabels() {

        return this.taskGatewayInterface.getAllLabels().stream().map((label) -> new LabelDTO(label.getName(), label.getColor())).toList();

    }
    
    /**
     * Adds a label to a task.
     *
     * @param  taskId  the ID of the task to add the label to
     * @param  name    the name of the label to add
     */
    @Override
    public void addLabelToTask(Long taskId, String name) {

        this.taskGatewayInterface.addLabelToTask(taskId, name);

    }

    /**
     * Converts a TaskRequestDTO object to a Task object.
     *
     * @param taskRequestDTO the TaskRequestDTO object to be converted
     * @return the converted Task object
     */
    private Task DTOToDomain(TaskRequestDTO taskRequestDTO) {

        TaskList taskList = new TaskList(taskRequestDTO.getTaskListName(), LocalDateTime.now());

        return new Task(
                taskRequestDTO.getTitle(),
                taskRequestDTO.getDescription(),
                taskRequestDTO.getDueDate(),
                taskRequestDTO.getStatus(),
                taskRequestDTO.getPriority(),
                taskList,
                LocalDateTime.now(),
                taskRequestDTO.getLabels()
            );
    }

    private TaskResponseDTO domainToDTO(Task task) {

        TaskListResponseDTO taskListDTO = new TaskListResponseDTO(
            task.getTaskList().getId(), 
            task.getTaskList().getName(), 
            task.getTaskList().getCreatedAt()
            );

        List<LabelDTO> labelsDTO = task.getLabels().stream().map((label) -> new LabelDTO(label.getName(), label.getColor())).toList();

        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getStatus(),
                task.getPriority(),
                taskListDTO,
                task.getUpdatedAt(),
                labelsDTO
            );

    }

}
