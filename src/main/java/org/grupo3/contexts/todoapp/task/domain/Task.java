package org.grupo3.contexts.todoapp.task.domain;

public class Task {
    private Integer id;
    private String name;
    private Boolean status;

    private Task(Integer id, String name, Boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public static Task createWithId(Integer id, String name, Boolean status) {
        return new Task(id, name, status);
    }

    public static Task createWithoutId(String name, Boolean status) {
        return new Task(null, name, status);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Task(id=%s, name=%s, status=%b)", id, name, status);
    }
}
