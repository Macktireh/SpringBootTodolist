package com.asynclearning.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asynclearning.todolist.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
