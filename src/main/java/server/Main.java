package server;

import server.database.DbConnection;
import java.sql.ResultSet;

public class Main {
    DbConnection dbConnection = DbConnection.getInstance();

    ResultSet test = dbConnection.getAllTables();
}
