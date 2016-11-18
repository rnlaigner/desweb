package web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import airlinesystem.entity.Order;
import airlinesystem.entity.User;
 
public class PersistenceTest{
	private static EntityManager em;
    /**
     * @param args
     */
    public static void main(String[] args) {
    	
    	EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("web");
    	
    	em = emf.createEntityManager();
 
        try {
            em.getTransaction().begin();
             
            User user = new User();
            user.setEmail("abc123");
            user.setPassword("abc123");
            
            Order order = new Order();
            order.setUser(user);
             
            em.persist(user);
            
            em.persist(order);
             
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            emf.close();
        }
         
        System.out.println("It is over");
    }
}
