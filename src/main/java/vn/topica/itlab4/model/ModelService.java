package vn.topica.itlab4.model;

import vn.topica.itlab4.utils.ConnectionUtil;
import vn.topica.itlab4.utils.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModelService
{
	private static ModelService service;
	
	public static ModelService getInstance()
	{
		if (service == null)
		{
			service = new ModelService();
		}
		return service;
	}
	
	public <T> List<T> getListObject(Class<T> type, String query)
			throws SQLException
	{
		List<T> list = new ArrayList<T>();
		Connection c = ConnectionUtil.getConnection();
		try (Statement stmt = c.createStatement())
		{
			try (ResultSet rst = stmt.executeQuery(query))
			{
				while (rst.next())
				{
					T t = type.newInstance();
					Utils.loadObject(rst, t);
					list.add(t);
				}
			}
			c.close();
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			c.close();
			throw new RuntimeException("Unable to get the records: " + e.getMessage(), e);
		}
		return list;
	}
	
	public <T> List<T> getListObjectAdvance(Class<T> type, String query)
			throws SQLException
	{
		List<T> list = new ArrayList<T>();
		Connection c = ConnectionUtil.getConnection();
		try (Statement stmt = c.createStatement())
		{
			try (ResultSet rst = stmt.executeQuery(query))
			{
				while (rst.next())
				{
					T t = type.newInstance();
					Utils.loadObjectAdvance(rst, t);
					list.add(t);
				}
			}
			c.close();
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			c.close();
			throw new RuntimeException("Unable to get the records: " + e.getMessage(), e);
		}
		return list;
	}
	
}
