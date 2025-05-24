package org.grupo3.contexts.todoapp.task.application;

import org.grupo3.contexts.todoapp.task.domain.Task;
import org.grupo3.contexts.todoapp.task.domain.TaskRepository;

public class TaskRegisterer {
    private final TaskRepository repository;

    public TaskRegisterer(TaskRepository repository) {
        this.repository = repository;
    }

    public Task register(String name, Boolean status) {
        Task taskWithoutId = Task.createWithoutId(name, status);

        System.out.println(taskWithoutId);

        return repository.save(taskWithoutId);
    }

}
