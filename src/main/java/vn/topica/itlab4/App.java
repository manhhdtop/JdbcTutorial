package vn.topica.itlab4;

import vn.topica.itlab4.entity.ClassEntity;
import vn.topica.itlab4.model.Model;

import java.util.List;

public class App
{
	public static void main(String[] args)
	{
		Model model = new Model();

		/*
		 * Ex 1: Lazy load
		 */
		System.out.println("List class:");
		List<ClassEntity> classes = model.getClasses();
		if (classes != null)
		{
			classes.forEach(c -> {
				System.out.println(c);
				if (c.getListStudent() == null)
				{
					c.setListStudent(model.getStudentByClass(c.getId()));
				}
			});
			System.out.println("List class with student:");
			classes.forEach(System.out::println);
		}
		else
		{
			System.out.println("Something when wrong!. Cannot get list class");
		}
		/*
		 * Ex 2: Eager load
		 */
		System.out.println("List class with student:");
		classes = model.getClassesAdvance();
		if (classes != null)
		{
			classes.forEach(System.out::println);

		}
	}
}
