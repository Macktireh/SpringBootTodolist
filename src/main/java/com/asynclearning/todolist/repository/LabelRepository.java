package com.asynclearning.todolist.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asynclearning.todolist.entity.LabelEntity;

public interface LabelRepository extends JpaRepository<LabelEntity, Long> {

    Optional<LabelEntity> findByName(String name);

    Optional<LabelEntity> findByColor(String color);

}
