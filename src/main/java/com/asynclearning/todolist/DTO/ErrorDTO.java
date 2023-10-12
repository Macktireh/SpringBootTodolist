package com.asynclearning.todolist.DTO;

public record ErrorDTO(
        int status,
        String detail) {
}
