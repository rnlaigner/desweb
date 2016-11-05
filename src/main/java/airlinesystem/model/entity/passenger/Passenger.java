package airlinesystem.model.entity.passenger;

import airlinesystem.model.entity.airline.Ticket;
import airlinesystem.model.valueobject.enums.AgeCategory;
import java.util.Date;
import java.util.List;

public class Passenger
{
    private String name;
    private Date birth;
    private String address;
    private String cpf;
    private String telephone;
    private AgeCategory ageCategory;
    
    private List<Ticket> tickets;
    
    public Passenger(String name, Date birth, String address, String cpf)
    {
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.cpf = cpf;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public Date getBirth() 
    {
        return birth;
    }

    public void setBirth(Date birth) 
    {
        this.birth = birth;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getCpf() 
    {
        return cpf;
    }

    public void setCpf(String cpf) 
    {
        this.cpf = cpf;
    }

    public List<Ticket> getTickets() 
    {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) 
    {
        this.tickets = tickets;
    }

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public AgeCategory getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}
    
}
