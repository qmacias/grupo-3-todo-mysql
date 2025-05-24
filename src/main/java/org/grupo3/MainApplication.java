package org.grupo3;

import org.grupo3.contexts.shared.infrastructure.ConnectionProvider;
import org.grupo3.contexts.todoapp.task.application.TaskRegisterer;
import org.grupo3.contexts.todoapp.task.domain.Task;
import org.grupo3.contexts.todoapp.task.domain.TaskRepository;
import org.grupo3.contexts.todoapp.task.infrastructure.MySQLTaskRepository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Grupo-3-Todo-MySQL
 */
public class MainApplication {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionProvider.getConnection();

        if (!(connection == null)) {
            System.out.println("Successfully connected to MySQL database.");
        }

        TaskRepository repository = new MySQLTaskRepository();

        TaskRegisterer taskRegisterer = new TaskRegisterer(repository);

        Task taskWithId = taskRegisterer.register("Do the laundry", false);

        System.out.println(taskWithId);
    }

}
