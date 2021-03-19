package ru.litvinov.springsecurity100500;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class SpringSecurity100500Application {

	public static void main(String[] args)  {
		SpringApplication.run(SpringSecurity100500Application.class, args);
	}

}
