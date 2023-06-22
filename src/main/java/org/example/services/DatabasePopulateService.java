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
            populateService.populateWorkerTable();
            populateService.populateClientTable();
            populateService.populateProjectTable();
            populateService.populateProjectWorkerTable();
        } finally {
            populateService.closeConnection();
        }
    }

    public void populateWorkerTable() {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_WORKER)) {
            statement.setString(1, "John Doe");
            statement.setDate(2, Date.valueOf("1990-05-15"));
            statement.setString(3,"Senior");
            statement.setInt(4, 8000);
            statement.executeUpdate();

            System.out.println("Done!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void populateClientTable() {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_CLIENT)) {
            statement.setString(1, "Emma Robert");
            statement.executeUpdate();

            System.out.println("Done!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void populateProjectTable() {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PROJECT)) {
            statement.setInt(1, 1);
            statement.setDate(2, Date.valueOf("2022-01-01"));
            statement.setDate(3, Date.valueOf("2022-03-31"));
            statement.executeUpdate();

            System.out.println("Done!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void populateProjectWorkerTable() {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PROJECT_WORKER)) {
            statement.setInt(1, 1);
            statement.setInt(2, 2);
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

