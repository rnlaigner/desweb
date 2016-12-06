package airlinesystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
Classe flight é a instancia de um passageiro em uma rota
*/
@Entity
@Table(name="flight")
public class Flight implements Serializable
{  
	/**
	 * 
	 */
	private static final long serialVersionUID = 8199962339110796448L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="route_id")
    private Route route;
	
	@Column(nullable = true)
    private Long number;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="seat_id")
    private Seat seat;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="passenger_id")
	private Passenger passenger;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="order_id")
	private Order order;
	
	@OneToOne
	@JoinColumn(name="checkin_id")
	private CheckIn checkin;

	public Flight()
    {
    }
    
    public Flight(Route route, Long number, Seat seat, Passenger passenger, Order order)
    {
        this.route = route;
        this.number = number;
        this.seat = seat;
        this.passenger = passenger;
        this.order = order;
    }

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
    
    public Route getRoute() 
    {
        return this.route;
    }
    

    public void setRoute(Route route) 
    {
        this.route = route;
    }

    public Long getNumber() 
    {
        return number;
    }

    public void setNumber(Long number) 
    {
        this.number = number;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	public CheckIn getCheckin() {
		return checkin;
	}

	public void setCheckin(CheckIn checkin) {
		this.checkin = checkin;
	}
}
