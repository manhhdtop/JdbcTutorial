package vn.topica.itlab4;

import org.reflections.Reflections;
import vn.topica.itlab4.annotation.Table;
import vn.topica.itlab4.entity.ClassEntity;
import vn.topica.itlab4.model.Model;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

public class Main
{
	public static void main(String[] args) throws NoSuchFieldException
	{
		Model model = new Model();

		Reflections reflections = new Reflections("vn.topica.itlab4.entity");
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Table.class);

		for (Class<?> clazz : annotated) {
			Table table = clazz.getAnnotation(Table.class);
			System.out.println(table.name());
		}

//		/*
//		 * Ex 2: Eager load
//		 */
//		System.out.println("List class with student:");
//		List<ClassEntity> classes = model.getClassesAdvance();
//		if (classes != null)
//		{
//			classes.forEach(System.out::println);
//
//		}
	}
}
