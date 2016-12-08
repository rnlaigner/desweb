package airlinesystem.entity;

import java.io.Serializable;
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
public class Passenger implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4370850618932450072L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;
	
	@Column(nullable = false)
    private String name;
	
	@Column(nullable = true)
    private Date birth;
	
	@Column(nullable = true)
    private String address;
	
	@Column(nullable = true)
    private String cpf;
	
	@Column(nullable = true)
    private String identificationNumber;

	@Column(nullable = false)
    private String nationality;

	@Column(nullable = true)
    private String passport;

	@Column(nullable = true)
    private String telephone;
	
	//Fisicamente
	@Column(nullable = true)
    private Boolean disabled;
	
	@Enumerated(EnumType.STRING)
    private AgeCategory ageCategory;
    
    @OneToMany(mappedBy = "passenger")
    private List<Flight> flights;
    
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
    
	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
    
	public String getPassport() {
		return passport;
	}
	
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setPassport(String passport) {
		this.passport = passport;
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

    public List<Flight> getTickets() 
    {
        return flights;
    }

    public void setTickets(List<Flight> flights) 
    {
        this.flights = flights;
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

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
    
}
