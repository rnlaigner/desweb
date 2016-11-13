package airlinesystem.model.entity.airline;

import airlinesystem.model.entity.seat.Seat;
import java.util.List;

public class Airplane 
{
    private List<Seat> seats;
    private int airplaneNumber;
    private String company;
    private String model;
    private int id;
    
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
}
