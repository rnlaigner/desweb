package airlinesystem.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="airplane")
public class Airplane 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
	private Float id;
	
	@OneToMany(mappedBy = "airplane")
    private List<Seat> seats;
    
    @Column(nullable = true)
    private int airplaneNumber;
    
    @Column(nullable = true)
    private String company;
    
    @Column(nullable = true)
    private String model;
    
    public Airplane()
    {
    }
    
    public Airplane(int airplaneNumber, List<Seat> seats)
    {
        this.airplaneNumber = airplaneNumber;
        this.seats = seats;
    }

    public Airplane(int airplaneNumber, List<Seat> seats, String company, String model)
    {
        this.airplaneNumber = airplaneNumber;
        this.seats = seats;
        this.company = company;
        this.model = model;
    }

    public int getAirplaneNumber() 
    {
        return airplaneNumber;
    }

    public void setAirplaneNumber(int airplaneNumber) 
    {
        this.airplaneNumber = airplaneNumber;
    }

    public List<Seat> getSeats() 
    {
        return seats;
    }

    public void setSeats(List<Seat> seats) 
    {
        this.seats = seats;
    }

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Float getId() {
		return id;
	}

	public void setId(Float id) {
		this.id = id;
	}
    
}
