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
            
            Seat seat1 = new Seat("1",SeatCategory.ECONOMY);
            Seat seat2 = new Seat("2",SeatCategory.ECONOMY);
            
            List<Seat> seats = new ArrayList<Seat>();
            
            seats.add(seat1);
            seats.add(seat2);
            
            Airplane airplane = new Airplane("Airbus A320-100/200",seats);
            
            Airport airport1 = new Airport("GIG","Rio de Janeiro");
            
            Airport airport2 = new Airport("REC","Recife");
            
            Date date1 = new Date();
            
            Calendar cal = Calendar.getInstance(); // creates calendar
            cal.setTime(date1); // sets calendar time/date
            cal.add(Calendar.HOUR_OF_DAY, 5); // adds one hour
            cal.getTime(); // returns new date object, one hour in the future
            
            Date date2 = cal.getTime();
            
            Route route = new Route(airport1,airport2, date1, date2, airplane, new Float(1000));
            
            em.persist(user);
            
            em.persist(seat1);
            em.persist(seat2);
            em.persist(airplane);
            em.persist(airport1);
            em.persist(airport2);
            em.persist(route);
             
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
