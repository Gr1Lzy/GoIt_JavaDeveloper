package org.example.services;

import org.example.models.Client;

import java.sql.*;
import java.util.*;

public class ClientService {
    private final PreparedStatement createStatement;
    private final PreparedStatement readStatement;
    private final PreparedStatement updateStatement;
    private final PreparedStatement deleteStatement;
    private final PreparedStatement readListStatement;

    public ClientService(Connection connection) {
        try {
            createStatement = connection.prepareStatement("INSERT INTO CLIENT (NAME) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);
            readStatement = connection.prepareStatement("SELECT ID, NAME FROM CLIENT WHERE ID = ?");
            updateStatement = connection.prepareStatement("UPDATE CLIENT SET NAME = ? WHERE ID = ?");
            deleteStatement = connection.prepareStatement("DELETE FROM CLIENT WHERE ID = ?");
            readListStatement = connection.prepareStatement("SELECT * FROM CLIENT");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public long create(String name) throws SQLException {
        createStatement.setString(1, name);
        createStatement.executeUpdate();
        ResultSet generatedKeys = createStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getLong(1);
        } else {
            throw new SQLException("Id not found");
        }
    }

    public String getById(long id) throws SQLException {
        readStatement.setLong(1, id);
        ResultSet resultSet = readStatement.executeQuery();

        if (!resultSet.next()) {
            return null;
        }

        String name = resultSet.getString("name");

        Client result = new Client();
        result.setId(id);
        result.setName(name);

        return result.toString();
    }

    public void setName(long id, String name) throws SQLException {
        updateStatement.setString(1, name);
        updateStatement.setLong(2, id);
        int result = updateStatement.executeUpdate();
        if (result > 0) {
            System.out.println("Successfully renamed!");
        } else {
            System.out.println("ID not found.");
        }

    }

    //     - видаляє клієнта з ідентифікатором id
    public void deleteById(long id) throws SQLException {
        deleteStatement.setLong(1, id);
        int result = deleteStatement.executeUpdate();

        if (result > 0) {
            System.out.println("Successfully deleted!");
        } else {
            System.out.println("ID not found.");
        }
    }
    public List<Client> listAll() throws SQLException {
        List<Client> resultList = new ArrayList<>();
        ResultSet resultSet = readListStatement.executeQuery();

        while(resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getLong("id"));
            client.setName(resultSet.getString("name"));

            resultList.add(client);
        }

        return resultList;
    }
}
