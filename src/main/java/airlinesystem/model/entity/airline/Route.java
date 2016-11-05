package airlinesystem.model.entity.airline;

import java.time.Period;
import java.util.GregorianCalendar;

public class Route 
{
    private int id;
    private Airplane airplane;
    private Airport origin; //can become class airport
    private Airport destiny;
    private GregorianCalendar landTime;
    private GregorianCalendar flightTime;
    private double price;//Base-price. Should be multiplied by the weight of the Seat
    private Period duration;
    
    public Route(int routeId, Airport origin, Airport destiny, GregorianCalendar flightTime, GregorianCalendar landTime, Airplane airplane)
    { 
      this.id = routeId;
      this.origin = origin;
      this.destiny = destiny;
      this.landTime = landTime;
      this.flightTime = flightTime;
      this.airplane = airplane;
    }

    public Airplane getAirplane() 
    {
        return airplane;
    }

    public void setAirplane(Airplane airplane) 
    {
        this.airplane = airplane;
    }

    public Airport getOrigin() 
    {
        return origin;
    }

    public void setOrigin(Airport origin) 
    {
        this.origin = origin;
    }

    public Airport getDestiny() 
    {
        return destiny;
    }

    public void setDestiny(Airport destiny) 
    {
        this.destiny = destiny;
    }

    public GregorianCalendar getLandTime() 
    {
        return landTime;
    }

    public void setLandTime(GregorianCalendar landTime) 
    {
        this.landTime = landTime;
    }

    public GregorianCalendar getFlightTime() 
    {
        return flightTime;
    }

    public void setFlightTime(GregorianCalendar flightTime) 
    {
        this.flightTime = flightTime;
    }

    public double getPriceFactor() 
    {
        return price;
    }

    public void setPriceFactor(double price) 
    {
        this.price = price;
    }

    public Period getDuration() 
    {
        return duration;
    }

    public void setDuration(Period duration) 
    {
        this.duration = duration;
    }
    
    public void setRouteId( int routeId )
    {
        this.id = routeId;
    }
    
    public int getRouteId()
    {
        return this.id;
    }

}
