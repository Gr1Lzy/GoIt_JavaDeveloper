package org.example;

import java.sql.Connection;

public class DatabaseInitService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        database.executeSqlFile(database, connection, "init_db.sql");
    }
}
