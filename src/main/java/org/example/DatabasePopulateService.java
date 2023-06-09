package org.example;

import java.sql.Connection;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        database.executeSqlFile(database, connection, "populate_db.sql");
    }
}
