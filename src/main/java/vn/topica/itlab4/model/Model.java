package vn.topica.itlab4.model;

import vn.topica.itlab4.entity.ClassEntity;
import vn.topica.itlab4.entity.StudentEntity;
import vn.topica.itlab4.utils.JdbcConstant;

import java.sql.SQLException;
import java.util.List;

public class Model
{
	private ModelService service;
	
	public List<ClassEntity> getClasses()
	{
		List<ClassEntity> classes = null;
		String query = JdbcConstant.SELECT_CLASS;
		service = ModelService.getInstance();
		try
		{
			classes = service.getListObject(ClassEntity.class, query);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return classes;
	}
	
	public List<ClassEntity> getClassesAdvance()
	{
		List<ClassEntity> classes = null;
		String query = JdbcConstant.SELECT_CLASS_ADVANCE;
		service = ModelService.getInstance();
		try
		{
			classes = service.getListObjectAdvance(ClassEntity.class, query);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return classes;
	}
	
	public List<StudentEntity> getStudentByClass(int classId)
	{
		List<StudentEntity> students = null;
		String query =
				JdbcConstant.SELECT_STUDENT + " WHERE class_id=" + classId;
		service = ModelService.getInstance();
		try
		{
			students = service.getListObject(StudentEntity.class, query);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return students;
	}
}
