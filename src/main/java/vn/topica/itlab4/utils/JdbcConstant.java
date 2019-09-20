package vn.topica.itlab4.utils;

public class JdbcConstant
{
	public static final String DB_NAME = "jdbc_tutorial";
	public static final String HOST = "localhost";
	public static final int PORT = 3306;
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	
	public static final String SELECT_CLASS = "SELECT * FROM class";
	public static final String SELECT_CLASS_ADVANCE = "SELECT c.id as " +
			"class_id, c.name as class_name, c.description as class_description, s.id as " +
			"student_id, s.name as " +
			"student_name FROM class c, student s where c.id = s.class_id";
	public static final String SELECT_STUDENT = "SELECT * FROM student";
}
