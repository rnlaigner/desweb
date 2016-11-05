package airlinesystem.model.entity.seat;

import airlinesystem.model.valueobject.enums.SeatCategory;

public class Seat 
{
    private String airplaneSeat;
    private SeatCategory category;
    
    public Seat(String airplaneSeat, SeatCategory category)
    {
        this.airplaneSeat = airplaneSeat;
        this.category = category;
    }

    public String getAirplaneSeat() 
    {
        return airplaneSeat;
    }

    public void setAirplaneSeat(String airplaneSeat) 
    {
        this.airplaneSeat = airplaneSeat;
    }

    public SeatCategory getCategory() 
    {
        return category;
    }

    public void setCategory(SeatCategory category) 
    {
        this.category = category;
    }   
}
