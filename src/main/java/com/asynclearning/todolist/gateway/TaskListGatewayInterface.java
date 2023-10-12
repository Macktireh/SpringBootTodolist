package com.asynclearning.todolist.gateway;

import java.util.List;

import com.asynclearning.todolist.domain.TaskList;

public interface TaskListGatewayInterface {

    TaskList createTaskList(String name);

    List<TaskList> getAllTaskLists();

    TaskList getTaskListById(Long id);

    void updateTaskList(Long id, String name);

    void deleteTaskList(Long id);

}
