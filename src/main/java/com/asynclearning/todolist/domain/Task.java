package com.asynclearning.todolist.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.asynclearning.todolist.enums.Priority;
import com.asynclearning.todolist.enums.Status;

public class Task {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime dueDate;

    private Status status;

    private Priority priority;

    private TaskList taskList;

    private LocalDateTime updatedAt;

    private List<Label> labels;

    public Task(String title, String description, LocalDateTime dueDate, Status status, Priority priority,
            TaskList taskList, LocalDateTime updatedAt) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.taskList = taskList;
        this.updatedAt = updatedAt;
    }

    public Task(String title, String description, LocalDateTime dueDate, Status status, Priority priority,
            TaskList taskList, LocalDateTime updatedAt, List<Label> labels) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.taskList = taskList;
        this.updatedAt = updatedAt;
        this.labels = labels;
    }

    public Task(Long id, String title, String description, LocalDateTime dueDate, Status status, Priority priority,
            TaskList taskList, LocalDateTime updatedAt, List<Label> labels) {
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
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TaskList getTaskList() {
        return this.taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Label> getLabels() {
        return this.labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
}
