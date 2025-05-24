package org.grupo3;

import org.grupo3.contexts.shared.infrastructure.ConnectionProvider;
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

        Task taskWithoutId = Task.createWithoutId("Do the laundry", false);
        System.out.println(taskWithoutId);

        Task taskWithId = repository.save(taskWithoutId);
        System.out.println(taskWithId);
    }

}
