package airlinesystem.persistence;

import airlinesystem.model.entity.Airplane;
import airlinesystem.model.entity.Airport;
import airlinesystem.model.entity.Route;
import airlinesystem.model.entity.Seat;
import airlinesystem.model.entity.User;
import airlinesystem.model.enums.SeatCategory;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SimulateDB 
{
    
    public SimulateDB()
    {
        //
    }
    
    public static List<User> users = new ArrayList<User>();
    
    public List<Route> getRoutes(String origin, String destiny, String date, List<Route> routes)
    {
        List<Route> routesFlight = new ArrayList<Route>();
        
        for (Route route : routes)
        {
            String routeDestiny = route.getDestiny().getName();
            String routeOrigin = route.getOrigin().getName();
            //GregorianCalendar routeDayCalendar = route.getFlightTime();
            
            GregorianCalendar routeDayCalendar = new GregorianCalendar();
            
            //transformar gregorianCalendar no formato dd/MM/YYYY
            //day estara nesse formato
            
            StringBuilder sb = new StringBuilder();
            sb.append(routeDayCalendar.get(GregorianCalendar.DAY_OF_MONTH));
            sb.append("/");
            sb.append(routeDayCalendar.get(GregorianCalendar.MONTH));
            sb.append("/");
            sb.append(routeDayCalendar.get(GregorianCalendar.YEAR));
            String routeDay = sb.toString();
            
            if (routeOrigin.equals(origin) && routeDay.equals(date) && routeDestiny.equals(destiny))
            {
                routesFlight.add(route);
            }
        }
        return routesFlight;
    }
    
    public List<Route> retrieveRoutes() 
    {
        List<Route> routes = new ArrayList<Route>();
        List<Airplane> airplanes = new ArrayList<Airplane>();
        List<Seat> seats = new ArrayList<Seat>();
        List<Airport> airports = new ArrayList<Airport>();
        
        seats.add(new Seat("AC",SeatCategory.FIRST_CLASS));
        seats.add(new Seat("EA",SeatCategory.FIRST_CLASS));
        seats.add(new Seat("DF",SeatCategory.ECONOMY));
        seats.add(new Seat("IO",SeatCategory.ECONOMY));
        
        airplanes.add(new Airplane(1,seats,"American Airlines","ATY-3456"));
        
        airports.add(new Airport("GIG","Rio de Janeiro"));
        airports.add(new Airport("MIA","Miami"));
        airports.add(new Airport("BUE","Buenos Aires"));
        
        //routes.add(new Route(1,airports.get(0),airports.get(1),new GregorianCalendar(2016,10,15,20,30),new GregorianCalendar(2016,10,16,6,30),airplanes.get(0)));
        //routes.add(new Route(2,airports.get(1),airports.get(2),new GregorianCalendar(2016,10,16,8,30),new GregorianCalendar(2016,10,16,12,30),airplanes.get(0)));
        //routes.add(new Route(3,"GIG","Charlotte",new GregorianCalendar(2016,10,15,19,30),new GregorianCalendar(2016,10,16,4,30),airplanes.get(0)));
        //routes.add(new Route(4,"Charlotte","Boston",new GregorianCalendar(2016,10,16,9,30),new GregorianCalendar(2016,10,16,12,30),airplanes.get(0)));

        return routes;
    }
    
    /*
    public List<Flight> getBoughtFlights()
    {
        List<Route> routes = retrieveRoutes();
        List<Flight> routesFlight = new ArrayList<Flight>();
        List<RouteFlight> routeFlights = new ArrayList<RouteFlight>();
        
        routeFlights.add(new RouteFlight(routes.get(0),routes.get(0).getAirplane().getSeats().get(0),1));
        routeFlights.add(new RouteFlight(routes.get(1),routes.get(1).getAirplane().getSeats().get(0),2));
        
        routesFlight.add(new Flight(routeFlights,1));
        
        return routesFlight;
    }
    */
//    public List<Flight> getBoughtFlights(Route route)
//    {
//        List<Flight> routesFlight = getBoughtFlights();
//        
//        for(Flight flight : routesFlight)
//        {
//            if(flight.getRoutes())
//        }
//    }
    
    public List<User> retrieveUsers()
    {   
        if(users.isEmpty())
        {
            //users.add(new User(1,"rodrigo","vasco"));
            //users.add(new User(2,"erick","marxista"));
        }
        return users;
    }
    
    /*
    public User createAccount(String username, String password)
    {
        //start list if not initiated
        retrieveUsers();
        for (User user : users)
        {
            if(user.getUsername().equals(username))
            {
                throw new ExistantUsernameException();
                
            }
        }
        //User newUser = new User(users.size(),username,password);
        //users.add(newUser);
        //return newUser;
    }
    */
}
