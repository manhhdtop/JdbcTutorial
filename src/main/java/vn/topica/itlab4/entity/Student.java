package vn.topica.itlab4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable
{
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "class_id")
	private int classID;

	public Student()
	{

	}

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

	@Override
	public String toString()
	{
		return "Student: ID: " + id + "; Name: " + name;
	}
}
