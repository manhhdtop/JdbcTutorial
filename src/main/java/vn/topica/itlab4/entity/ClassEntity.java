package vn.topica.itlab4.entity;

import vn.topica.itlab4.annotation.Column;
import vn.topica.itlab4.annotation.OneToMany;
import vn.topica.itlab4.annotation.Table;

import java.util.List;

@Table(name = "class")
public class ClassEntity
{
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "student")
	private List<StudentEntity> listStudent;

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

	public List<StudentEntity> getListStudent()
	{
		return listStudent;
	}

	public void setListStudent(List<StudentEntity> listStudent)
	{
		this.listStudent = listStudent;
	}

	@Override
	public String toString()
	{
		return "Class[ID=" + id + "; "
				+ "Name=" + name + "; "
				+ "Description=" + description + "; "
				+ "Students=" + (listStudent == null ? "null" : listStudent.size()) + "]";
	}
}
