package airlinesystem.entity;

import java.time.Period;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="route")
public class Route 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="airplane_id")
    private Airplane airplane;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="originairport_id")
    private Airport origin;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="destinyairport_id")
    private Airport destiny;
	
	@Column(nullable = false)
    private Date landing;
    
    @Column(nullable = false)
    private Date departure;
    
    @Column(nullable = false)
    private Float price;
    
    @Transient
    private Period duration;
    
    public Route()
    { 
    	
    }
    
    public Route(Airport origin, Airport destiny, Date departure, Date landing, Airplane airplane, Float price)
    { 
      this.origin = origin;
      this.destiny = destiny;
      this.landing = landing;
      this.departure = departure;
      this.airplane = airplane;
      this.price = price;
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

    public Date getLandingTime() 
    {
        return landing;
    }

    public void setLandingTime(Date landingTime) 
    {
        this.landing = landingTime;
    }

    public Date getDepartureTime() 
    {
        return departure;
    }

    public void setDepartureTime(Date departureTime) 
    {
        this.departure = departureTime;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(Float price) 
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
    
    public void setId( Long id )
    {
        this.id = id;
    }
    
    public Long getId()
    {
        return id;
    }

}
