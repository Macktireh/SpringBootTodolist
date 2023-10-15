package com.asynclearning.todolist.gateway;

import java.util.Collection;
import java.util.List;

import com.asynclearning.todolist.domain.Label;
import com.asynclearning.todolist.domain.Task;

public interface TaskGatewayInterface {

    Task createTaskList(Task task);

    List<Task> getAllTaskLists();

    Task getTaskListById(Long id);

    void updateTaskList(Long id, Task task);

    void deleteTaskList(Long id);

    Label createLabel(Label label);

    Collection<Label> getAllLabels();

    void addLabelToTask(Long taskId, String name);
}
