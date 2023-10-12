package com.asynclearning.todolist.domain;

import java.time.LocalDateTime;

import com.asynclearning.todolist.enums.Priority;
import com.asynclearning.todolist.enums.Status;

public class Task {

    private String title;

    private String description;

    private LocalDateTime dueDate;

    private Status status;

    private Priority priority;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private int taskListId;

    public Task(String title, String description, LocalDateTime dueDate, Status status, Priority priority,
            LocalDateTime createdAt, LocalDateTime updatedAt, int taskListId) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.taskListId = taskListId;
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

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getTaskListId() {
        return this.taskListId;
    }

    public void setTaskListId(int taskListId) {
        this.taskListId = taskListId;
    }

}
