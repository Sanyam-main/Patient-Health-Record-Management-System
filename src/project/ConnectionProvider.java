
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String password = System.getenv("DB_PASSWORD");

            if (password == null || password.isEmpty()) {
                throw new SQLException(
                    "DB_PASSWORD environment variable is not set."
                );
            }

            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
