package com.cg.mps.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.mps.exception.MPSException;

public class JDBC_Utility {

	private static Connection connection = null;

	public static Connection getconnection() throws MPSException {
		
		File file = null;
		FileInputStream inputStream = null;
		Properties properties = null;
		
		file = new File("resources/jdbc.properties");
		
		try {
			
			inputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(inputStream);			
			
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username =properties.getProperty("username");
			String password = properties.getProperty("password");
			
			
			Class.forName(driver);
			connection =DriverManager.getConnection(url,username,password);
			
			
		}catch (FileNotFoundException e) {
			throw new MPSException("File not exist");
		} catch (IOException e) {
			throw new MPSException("unable to read data from file");
		} catch (ClassNotFoundException e) {
			throw new MPSException("Problem in Class Loading");
		} catch (SQLException e) {
			throw new MPSException("Problem in connecting to sql server");
		} 
		return connection;
	}

}
