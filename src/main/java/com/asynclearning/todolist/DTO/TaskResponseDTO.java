package com.asynclearning.todolist.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.asynclearning.todolist.enums.Priority;
import com.asynclearning.todolist.enums.Status;

public class TaskResponseDTO {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime dueDate;

    private Status status;

    private Priority priority;

    private TaskListResponseDTO taskList;

    private LocalDateTime updatedAt;

    private List<LabelDTO> labels;

    public TaskResponseDTO(Long id, String title, String description, LocalDateTime dueDate, Status status,
            Priority priority, TaskListResponseDTO taskList, LocalDateTime updatedAt, List<LabelDTO> labels) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.taskList = taskList;
        this.updatedAt = updatedAt;
        this.labels = labels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TaskListResponseDTO getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskListResponseDTO taskList) {
        this.taskList = taskList;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<LabelDTO> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelDTO> labels) {
        this.labels = labels;
    }

}
