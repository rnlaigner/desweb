package airlinesystem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import airlinesystem.enums.AgeCategory;

@Entity
@Table(name="passenger")
public class Passenger
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;
	
	@Column(nullable = false)
    private String name;
	
	@Column(nullable = false)
    private Date birth;
	
	@Column(nullable = false)
    private String address;
	
	@Column(nullable = false)
    private String cpf;
	
	@Column(nullable = false)
    private String telephone;
	
	@Enumerated(EnumType.STRING)
    private AgeCategory ageCategory;
    
    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets;
    
    public Passenger()
    {
    	
    }
    
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
