package server.database;

import java.sql.*;

public class DbConnection {
    private static volatile DbConnection instance;

    private final String url = "jdbc:mysql://localhost:3306/JavaChat";

    private final String user = "root";

    private final String pass = "123";

    private Connection connection;

    private DbConnection() {
    }

    public static DbConnection getInstance() {
        DbConnection result = instance;
        if (result != null) {
            return result;
        }
        synchronized (DbConnection.class) {
            if (instance == null) {
                instance = new DbConnection();
            }
            return instance;
        }
    }

    public Connection getConnection() {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            this.connection = conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public Statement createStatement()
    {
        try {
            return this.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getAllTables() {
        String tableSql = "SHOW FULL TABLES";

        try {
            return this.createStatement().executeQuery(tableSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
