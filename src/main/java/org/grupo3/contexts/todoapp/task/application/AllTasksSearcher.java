package org.grupo3.contexts.todoapp.task.application;

import org.grupo3.contexts.todoapp.task.domain.Task;
import org.grupo3.contexts.todoapp.task.domain.TaskRepository;

import java.util.List;

public class AllTasksSearcher {
    private final TaskRepository repository;

    public AllTasksSearcher(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> searchAll() {
        return repository.searchAll();
    }

}
