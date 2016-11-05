package airlinesystem.model.entity.airline;

import airlinesystem.model.entity.passenger.Passenger;

public class Ticket 
{
    private Flight flight;
    private double finalPrice;
    private Passenger passenger;
    private int ticketNumber;
    
    public Ticket(Flight flight)
    {
        this.flight = flight;
    }
    
    public double getPrice()
    {
        return this.finalPrice;
    }

    public Flight getFlight() 
    {
        return flight;
    }

    public void setFlight(Flight flight) 
    {
        this.flight = flight;
    }

    public Passenger getPassenger() 
    {
        return passenger;
    }

    public void setPassenger(Passenger passenger) 
    {
        this.passenger = passenger;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) 
    {
        this.ticketNumber = ticketNumber;
    }
    
    
}
