package airlinesystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="flight_id")
    private Flight flight;
    
    @Column(nullable = true)
    private double finalPrice;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="passenger_id")
    private Passenger passenger;
    
    @Column(nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int ticketNumber;
    
    public Ticket()
    {
        
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
