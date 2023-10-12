package com.asynclearning.todolist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asynclearning.todolist.entity.TaskListEntity;

public interface TaskListRepository extends JpaRepository<TaskListEntity, Long> {

    Optional<TaskListEntity> findByName(String name);

}
