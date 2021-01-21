package com.narga.fashion_blog;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUsername("SA");
		dataSource.setPassword("Narga1408");
		dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=FashionBlog");
		return dataSource;
	}
}
