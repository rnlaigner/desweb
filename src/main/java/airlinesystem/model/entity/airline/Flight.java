package airlinesystem.model.entity.airline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import airlinesystem.model.entity.seat.Seat;

/*
Classe flight é o vôo que o passageiro compra e está em seu ticket
*/
@Entity
@Table(name="flight")
public class Flight 
{  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="route_id")
    private Route route;
	
	@Column(nullable = true)
    private int number;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="seat_id")
    private Seat seat;
    
    public Flight()
    {
    }
    
    public Flight(Route route, int number)
    {
        this.route = route;
        this.number = number;
    }

    public Route getRoutes() 
    {
        return this.route;
    }

    public void setRoutes(Route route) 
    {
        this.route = route;
    }

    public int getNumber() 
    {
        return number;
    }

    public void setNumber(int number) 
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
}
