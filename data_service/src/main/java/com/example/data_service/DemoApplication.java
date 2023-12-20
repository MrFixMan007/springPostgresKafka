package com.example.data_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

@Configuration
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		String jdbcUrl = "jdbc:postgresql://postgres:5432/postgres";
		String username = "postgres";
		String password = "root";

		String sqlFilePath = "/data_app/back";


		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
			String sqlQuery = Files.lines(Paths.get(sqlFilePath)).collect(Collectors.joining(" "));

			try (Statement statement = connection.createStatement()) {
				statement.execute(sqlQuery);
			}

			System.out.println("SQL script from file executed successfully.");
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
