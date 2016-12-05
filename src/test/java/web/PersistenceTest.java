package web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import airlinesystem.entity.Airplane;
import airlinesystem.entity.Airport;
import airlinesystem.entity.Route;
import airlinesystem.entity.Seat;
import airlinesystem.entity.User;
import airlinesystem.enums.SeatCategory;
import java.util.List;
 
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
            
            Airplane airplane = new Airplane("Airbus A320-100/200");
            List<Seat> seats = new ArrayList<Seat>();
            
            for(int i = 1; i <= 39; i++){
	            Seat seat = new Seat(String.valueOf(i),SeatCategory.ECONOMY,airplane);
	            em.persist(seat);
	            seats.add(seat);
            }
            
            airplane.setSeats(seats);
            
            Airport airport1 = new Airport("GIG","Rio de Janeiro", Float.valueOf("150"));
            
            Airport airport2 = new Airport("REC","Recife", Float.valueOf("250"));
            
            Calendar cal = Calendar.getInstance(); 
            cal.set(2016, 12, 15, 12, 0, 0);
            
            Date date1 = cal.getTime(); 
            
            cal.add(Calendar.HOUR_OF_DAY, 5); 
            
            Date date2 = cal.getTime();
            
            Route route1 = new Route(airport1,airport2, date1, date2, airplane, new Float(1000));
            
            cal.set(2016, 12, 20, 12, 0);
            
            Date date3 = cal.getTime();
            
            cal.add(Calendar.HOUR_OF_DAY, 5); 
            
            Date date4 = cal.getTime();
            
            Route route2 = new Route(airport2,airport1, date3, date4, airplane, new Float(1000));
            
            em.persist(user);
            em.persist(airplane);
            em.persist(airport1);
            em.persist(airport2);
            em.persist(route1);
            em.persist(route2);
             
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
