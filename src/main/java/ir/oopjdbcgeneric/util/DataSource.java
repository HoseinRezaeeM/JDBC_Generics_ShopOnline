package ir.oopjdbcgeneric.util;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    @Getter
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(
                    ApplicationProperties.URL,
                    ApplicationProperties.USERNAME,
                    ApplicationProperties.PASSWORD);

        } catch (SQLException e) {
            System.out.println("Wrong DataBase Connetion!");
        }
    }
}
