package org.example.services;

import org.example.Database;
import org.example.models.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final String SQL_DIRECTORY = "src/main/resources/sql/";
    Database database = Database.getInstance();
    Connection connection = database.getConnection();
    private List<MaxProjectCountClient> executeMaxProjectsClientQuery(String sqlQuery) {
        List<MaxProjectCountClient> clients = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("project_count");
                MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    private List<MaxSalaryCountWorker> executeMaxSalaryWorkersQuery(String sqlQuery) {
        List<MaxSalaryCountWorker> workers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                MaxSalaryCountWorker worker = new MaxSalaryCountWorker(name, salary);
                workers.add(worker);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workers;
    }

    private List<YoungestAndEldestWorker> executeYoungestAndOldestWorkersQuery(String sqlQuery) {
        List<YoungestAndEldestWorker> workers = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String birthday = resultSet.getDate("birthday").toString();
                YoungestAndEldestWorker worker = new YoungestAndEldestWorker(name, birthday);
                workers.add(worker);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workers;
    }

    private List<ProjectPrice> executeProjectPricesQuery(String sqlQuery) {
        List<ProjectPrice> projects = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String startDate = resultSet.getDate("start_date").toString();
                String finishDate = resultSet.getDate("finish_date").toString();
                ProjectPrice project = new ProjectPrice(id, startDate, finishDate);
                projects.add(project);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projects;
    }

    private List<LongestProject> executeLongestProjects(String sqlQuery) {
        List<LongestProject> projects = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int clientId = resultSet.getInt("client_id");
                String startDate = resultSet.getDate("start_date").toString();
                String finishDate = resultSet.getDate("finish_date").toString();
                int durationMonths = resultSet.getInt("duration_months");
                LongestProject project = new LongestProject(id, clientId, startDate, finishDate, durationMonths);
                projects.add(project);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projects;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String sqlFilePath = SQL_DIRECTORY + "find_max_projects_client.sql";
        String sqlQuery = readSqlQueryFromFile(sqlFilePath);
        return executeMaxProjectsClientQuery(sqlQuery);
    }

    public List<MaxSalaryCountWorker> findMaxSalaryWorkers() {
        String sqlFilePath = SQL_DIRECTORY + "find_max_salary_worker.sql";
        String sqlQuery = readSqlQueryFromFile(sqlFilePath);
        return executeMaxSalaryWorkersQuery(sqlQuery);
    }

    public List<YoungestAndEldestWorker> findYoungestAndOldestWorkers() {
        String sqlFilePath = SQL_DIRECTORY + "find_youngest_oldest_workers.sql";
        String sqlQuery = readSqlQueryFromFile(sqlFilePath);
        return executeYoungestAndOldestWorkersQuery(sqlQuery);
    }

    public List<ProjectPrice> getProjectPrices() {
        String sqlFilePath = SQL_DIRECTORY + "print_project_prices.sql";
        String sqlQuery = readSqlQueryFromFile(sqlFilePath);
        return executeProjectPricesQuery(sqlQuery);
    }

    public List<LongestProject> findLongestProjects() {
        String sqlFilePath = SQL_DIRECTORY + "find_longest_project.sql";
        String sqlQuery = readSqlQueryFromFile(sqlFilePath);
        return executeLongestProjects(sqlQuery);
    }

    private String readSqlQueryFromFile(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
