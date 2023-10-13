package com.asynclearning.todolist.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.asynclearning.todolist.entity.LabelEntity;

public interface LabelRepository extends JpaRepository<LabelEntity, Long> {

    LabelEntity findByName(String name);

}
