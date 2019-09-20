package vn.topica.itlab4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TestHibernate
{
	public static void main(String[] args)
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();

		if (factory != null)
		{
			Session session = factory.getCurrentSession();

			try
			{
				session.getTransaction().begin();

				List<Class> classes = session.createQuery("FROM Student").getResultList();

				classes.forEach(System.out::println);

				session.getTransaction().commit();
			}
			catch (Exception e)
			{
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
	}
}

