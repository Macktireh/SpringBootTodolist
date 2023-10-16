package com.asynclearning.todolist.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.asynclearning.todolist.domain.Label;
import com.asynclearning.todolist.enums.Priority;
import com.asynclearning.todolist.enums.Status;

public class TaskRequestDTO {

    private String title;

    private String description;

    private LocalDateTime dueDate;

    private Status status;

    private Priority priority;

    private String taskListName;

    private Optional<List<Label>> labels;

    public TaskRequestDTO(String title, String description, LocalDateTime dueDate, Status status, Priority priority,
            String taskListName, Optional<List<Label>> labels) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.taskListName = taskListName;
        this.labels = labels;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getTaskListName() {
        return this.taskListName;
    }

    public void setTaskListName(String taskListName) {
        this.taskListName = taskListName;
    }

    public List<Label> getLabels() {
        return this.labels == null ? null : this.labels.get();
    }

    public void setLabels(List<Label> labels) {
        this.labels = Optional.of(labels);
    }

}
