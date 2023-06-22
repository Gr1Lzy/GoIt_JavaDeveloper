package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Database {
    private static final Database INSTANCE = new Database();
    private final Connection connection;

    private Database() {
        try {
            String connectionUrl = "jdbc:h2:./test";
            this.connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection () {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeSqlFile(Database database, Connection connection, String fileName) {
        try {
            String sqlFile = "src/main/resources/sql/"+fileName;
            String sql = readFile(sqlFile);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();

            System.out.println("Database initialized successfully.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            database.closeConnection();
        }
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }
        reader.close();
        return content.toString();
    }
}