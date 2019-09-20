package vn.topica.itlab4.entity;

import vn.topica.itlab4.annotation.Column;
import vn.topica.itlab4.annotation.Table;

@Table(name = "student")
public class StudentEntity
{
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "class_id")
	private int classID;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getClassID()
	{
		return classID;
	}
	
	public void setClassID(int classID)
	{
		this.classID = classID;
	}
}
