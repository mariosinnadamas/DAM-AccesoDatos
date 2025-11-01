package ejercicios41;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "alumno";
    private static final String pass = "alumno";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, pass);
    }
}
