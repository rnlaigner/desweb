package airlinesystem.model.entity;

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
    private Float id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="airplane_id")
    private Airplane airplane;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="originairport_id")
    private Airport origin;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="detinyairport_id")
    private Airport destiny;
	
	@Column(nullable = false)
    private Date landTime;
    
    @Column(nullable = false)
    private Date flightTime;
    
    @Column(nullable = false)
    private double price;//Base-price. Should be multiplied by the weight of the Seat
    
    @Transient
    private Period duration;
    
    public Route()
    { 
    	
    }
    
    public Route(Float routeId, Airport origin, Airport destiny, Date flightTime, Date landTime, Airplane airplane)
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

    public Date getLandTime() 
    {
        return landTime;
    }

    public void setLandTime(Date landTime) 
    {
        this.landTime = landTime;
    }

    public Date getFlightTime() 
    {
        return flightTime;
    }

    public void setFlightTime(Date flightTime) 
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
    
    public void setRouteId( Float routeId )
    {
        this.id = routeId;
    }
    
    public Float getRouteId()
    {
        return id;
    }

}
