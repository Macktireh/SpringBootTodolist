package com.asynclearning.todolist.gateway;

import java.util.List;

import com.asynclearning.todolist.domain.TaskList;
import com.asynclearning.todolist.entity.TaskListEntity;

public interface TaskListGatewayInterface {

    TaskList createTaskList(String name);

    List<TaskList> getAllTaskLists();

    TaskList getTaskListById(Long id);

    TaskListEntity getTaskListByIdJPA(Long id);

    void updateTaskList(Long id, String name);

    void deleteTaskList(Long id);

    TaskList entityToDomain(TaskListEntity taskListEntity);

}
