/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="checkin")
public class CheckIn implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6130423024450563065L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;
	
	//@OneToOne(mappedBy="checkin")
    private Flight flight;
    
	@Column(nullable = true)
    private Date date;
    
    public CheckIn()
    {
    }
    
    public CheckIn(Flight flight, Date date)
    {
        this.flight = flight;
        this.date = date;
    }
    
    public CheckIn(Flight flight)
    {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
    
}
