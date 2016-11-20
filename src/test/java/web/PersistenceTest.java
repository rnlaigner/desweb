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
            
            Seat seat1 = new Seat("1",SeatCategory.ECONOMY,airplane);
            Seat seat2 = new Seat("2",SeatCategory.ECONOMY,airplane);
            
            List<Seat> seats = new ArrayList<Seat>();
            
            seats.add(seat1);
            seats.add(seat2);
            
            airplane.setSeats(seats);
            
            Airport airport1 = new Airport("GIG","Rio de Janeiro");
            
            Airport airport2 = new Airport("REC","Recife");
            
            Calendar cal = Calendar.getInstance(); 
            cal.set(2016, 11, 1, 12, 0, 0);
            
            Date date1 = cal.getTime(); 
            
            cal.add(Calendar.HOUR_OF_DAY, 5); 
            
            Date date2 = cal.getTime();
            
            Route route1 = new Route(airport1,airport2, date1, date2, airplane, new Float(1000));
            
            cal.set(2016, 11, 10, 12, 0);
            
            Route route2 = new Route(airport2,airport1, cal.getTime(), cal.getTime(), airplane, new Float(1000));
            
            em.persist(user);
            
            em.persist(seat1);
            em.persist(seat2);
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
