package airlinesystem.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateInit 
{
	public SessionFactory sessionFactory;
	
	private static final HibernateInit hibernateInit =  new HibernateInit();
	
	private HibernateInit()
	{
		
	}
	
	public static HibernateInit getInstance()
	{
		return hibernateInit;
	}

	public void voidSetUp() throws Exception
	{
		StandardServiceRegistryBuilder standard = new StandardServiceRegistryBuilder();
		
		final StandardServiceRegistry registry = standard.configure().build();
		try{
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch (Exception e)
		{
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
