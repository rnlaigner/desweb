package airlinesystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Long id;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "airplane", cascade = CascadeType.ALL)
    private List<Seat> seats;
    
    @Column(nullable = true)
    private String company;
    
    @Column(nullable = true)
    private String model;
    
    public Airplane()
    {
    }
    
    public Airplane(String model)
    {
        this.model = model;
    }
    
    public Airplane(String model, List<Seat> seats)
    {
        this.model = model;
        this.seats = seats;
    }

    public Airplane(String model, List<Seat> seats, String company)
    {
        this.seats = seats;
        this.company = company;
        this.model = model;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
}
