package org.grupo3.contexts.todoapp.task.infrastructure;

import org.grupo3.contexts.shared.infrastructure.ConnectionProvider;
import org.grupo3.contexts.todoapp.task.domain.Task;
import org.grupo3.contexts.todoapp.task.domain.TaskRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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

    @Override
    public List<Task> searchAll() {
        List<Task> tasks = new LinkedList<>();
        try {
            String sql = "SELECT * FROM Task";

            Connection conn = ConnectionProvider.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                tasks.add(this.toTask(results));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    private Task toTask(ResultSet taskRegister) throws SQLException {
        return Task.createWithId(
                taskRegister.getInt(1),
                taskRegister.getString(2),
                taskRegister.getBoolean(3));
    }

}
