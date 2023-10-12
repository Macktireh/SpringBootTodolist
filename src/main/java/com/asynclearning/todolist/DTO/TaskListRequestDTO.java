package com.asynclearning.todolist.DTO;

public class TaskListRequestDTO {

    private String name;

    public TaskListRequestDTO(String name) {
        this.name = name;
    }

    public TaskListRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
