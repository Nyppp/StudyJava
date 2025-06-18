package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private String url = "jdbc:postgresql://localhost:5432/hospital_reservation_system";
    private String user = "postgres";
    private String password = "1234";

    public Connection getConnection() throws Exception{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
