package org.example.services;

import org.example.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {
    private static final String INSERT_WORKER = "INSERT INTO worker(name, birthday, level, salary) VALUES (?, ?, ?, ?)";
    private static final String INSERT_CLIENT = "INSERT INTO client(name) VALUES (?)";
    private static final String INSERT_PROJECT = "INSERT INTO project(client_id, start_date, finish_date) VALUES (?, ?, ?)";
    private static final String INSERT_PROJECT_WORKER = "INSERT INTO project_worker(project_id, worker_id) VALUES (?, ?)";
    Database database = Database.getInstance();
    Connection connection = database.getConnection();

    public static void main(String[] args) {
        DatabasePopulateService populateService = new DatabasePopulateService();
        try {
            populateService.populateWorkerTable("John Doe", Date.valueOf("1990-05-15"), "Senior", 8000);
            populateService.populateClientTable("Emma Robert");
            populateService.populateProjectTable(1, Date.valueOf("2022-01-01"), Date.valueOf("2022-03-31"));
            populateService.populateProjectWorkerTable(1, 1);
        } finally {
            populateService.closeConnection();
        }
    }

    public void populateWorkerTable(String name, Date birthday, String level, int salary) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_WORKER)) {
            statement.setString(1, name);
            statement.setDate(2, birthday);
            statement.setString(3,level);
            statement.setInt(4, salary);
            statement.executeUpdate();

            System.out.println("Done!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void populateClientTable(String name) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_CLIENT)) {
            statement.setString(1, name);
            statement.executeUpdate();

            System.out.println("Done!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void populateProjectTable(int clientId, Date startDate, Date finishDate) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PROJECT)) {
            statement.setInt(1, clientId);
            statement.setDate(2, startDate);
            statement.setDate(3, finishDate);
            statement.executeUpdate();

            System.out.println("Done!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void populateProjectWorkerTable(int projectId, int workerId) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PROJECT_WORKER)) {
            statement.setInt(1, projectId);
            statement.setInt(2, workerId);
            statement.executeUpdate();

            System.out.println("Done!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

