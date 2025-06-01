package org.grupo3.contexts.todoapp.task.domain;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    List<Task> searchAll();
}
