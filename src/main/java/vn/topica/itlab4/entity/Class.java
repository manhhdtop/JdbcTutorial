package vn.topica.itlab4.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "class")
public class Class implements Serializable
{
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "student")
	private List<Student> listStudent;

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

	public List<Student> getListStudent()
	{
		return listStudent;
	}

	public void setListStudent(List<Student> listStudent)
	{
		this.listStudent = listStudent;
	}

	@Override
	public String toString()
	{
		return "Class[ID=" + id + "; " + "Name=" + name + "; " + "Description=" + description + "; "
				+ "Students=" + (listStudent == null ? "null" : listStudent.size()) + "]";
	}
}
