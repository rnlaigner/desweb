package airlinesystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import airlinesystem.enums.SeatCategory;

@Entity
@Table(name="seat")
public class Seat implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1187938611375752161L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;
	
	@Column(nullable = true)
    private String number;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="airplane_id")
	private Airplane airplane;
	
	@Enumerated(EnumType.STRING)
    private SeatCategory category;
    
	public Seat()
    {
    }
	
    public Seat(String number, SeatCategory category, Airplane airplane)
    {
        this.number = number;
        this.category = category;
        this.airplane = airplane;
    }

    public String getAirplaneSeat() 
    {
        return number;
    }

    public void setNumber(String number) 
    {
        this.number = number;
    }

    public SeatCategory getCategory() 
    {
        return category;
    }

    public void setCategory(SeatCategory category) 
    {
        this.category = category;
    }   
}
