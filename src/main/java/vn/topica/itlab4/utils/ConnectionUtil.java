package vn.topica.itlab4.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil
{
	private static BasicDataSource ds = new BasicDataSource();
	private static Connection c;

	private ConnectionUtil()
	{
	}

	static
	{
		String hostName = JdbcConstant.HOST;
		String dbName = JdbcConstant.DB_NAME;
		int port = JdbcConstant.PORT;
		String option = "?characterEncoding=UTF-8&serverTimezone=Europe/Paris";
		String connectionURL = "jdbc:mysql://" + hostName + ":" + port + "/" + dbName;

		ds.setUrl(connectionURL);
		ds.setUsername(JdbcConstant.USERNAME);
		ds.setPassword(JdbcConstant.PASSWORD);
		ds.setMinIdle(1);
		ds.setMaxIdle(5);

	}

	public static Connection getConnection() throws SQLException
	{
		return ds.getConnection();
	}

}
