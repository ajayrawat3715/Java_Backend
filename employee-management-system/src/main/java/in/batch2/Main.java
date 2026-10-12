package in.batch2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    void main() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db",
                    "root",
                    "86091");
            System.out.println("Hello World");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
