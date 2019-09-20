package vn.topica.itlab4.utils;

import vn.topica.itlab4.annotation.Column;
import vn.topica.itlab4.annotation.Table;
import vn.topica.itlab4.entity.ClassEntity;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Utils
{
	public static void loadObject(ResultSet rst, Object object)
			throws IllegalArgumentException, IllegalAccessException, SQLException
	{
		Class<?> zClass = object.getClass();
		for (Field field : zClass.getDeclaredFields())
		{
			field.setAccessible(true);
			Column column = field.getAnnotation(Column.class);
			Object value = null;
			if (column != null)
			{
				value = rst.getObject(column.name());
				Class<?> type = field.getType();
				if (isPrimitive(type))
				{
					Class<?> boxed = boxPrimitiveClass(type);
					boxed.cast(value);
				}
			}
			field.set(object, value);
		}
	}

	public static void loadObjectAdvance(ResultSet rst, Object object)
			throws IllegalArgumentException, SQLException
	{
		Map<Integer, ClassEntity> map = new HashMap<>();
		Class<?> zClass = object.getClass();

		ResultSetMetaData metaData = rst.getMetaData();
		for (int i = 1; i <= metaData.getColumnCount(); i++)
		{
			System.out.println(metaData.getColumnLabel(i) + ": " + rst.getObject(i));
			Field field = null;
			try
			{
				field = zClass.getField(metaData.getColumnName(i));
				System.out.println(field.getName());
			}
			catch (NoSuchFieldException e)
			{
				System.out.println("null");
			}
		}
	}

	private static Class<?> boxPrimitiveClass(Class<?> type)
	{
		if (type == int.class)
		{
			return Integer.class;
		}
		if (type == long.class)
		{
			return Long.class;
		}
		if (type == double.class)
		{
			return Double.class;
		}
		if (type == float.class)
		{
			return Float.class;
		}
		if (type == boolean.class)
		{
			return Boolean.class;
		}
		if (type == byte.class)
		{
			return Byte.class;
		}
		if (type == char.class)
		{
			return Character.class;
		}
		if (type == short.class)
		{
			return Short.class;
		}

		String string = "class '" + type.getName() + "' is not a primitive";
		throw new IllegalArgumentException(string);
	}

	private static boolean isPrimitive(Class<?> type)
	{
		return (type == int.class || type == long.class ||
				type == double.class || type == float.class ||
				type == boolean.class || type == byte.class ||
				type == char.class || type == short.class);
	}
}
