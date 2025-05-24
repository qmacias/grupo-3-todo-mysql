package org.grupo3.contexts.todoapp.task.infrastructure;

import org.grupo3.contexts.shared.infrastructure.ConnectionProvider;
import org.grupo3.contexts.todoapp.task.domain.Task;
import org.grupo3.contexts.todoapp.task.domain.TaskRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLTaskRepository implements TaskRepository {
    @Override
    public Task save(Task task) {
        try {
            String sql = "INSERT INTO Task(name, status) VALUES (?, ?)";

            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, task.getName());
            statement.setBoolean(2, task.getStatus());

            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();

            if (result.next()) {
                task.setId(result.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return task;
    }

}
