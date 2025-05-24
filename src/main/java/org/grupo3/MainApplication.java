package org.grupo3;

import org.grupo3.contexts.shared.infrastructure.ConnectionProvider;
import org.grupo3.contexts.todoapp.task.domain.Task;

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

        Task task = Task.createWithoutId("Wash the dishes", false);

        System.out.println(task);
    }

}
