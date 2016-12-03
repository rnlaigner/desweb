/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="checkin")
public class CheckIn 
{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="flight_id")
    private Flight flight;
    
	@Column(nullable = false)
    private Date date;
    
    public CheckIn()
    {
    }
    
    public CheckIn(Flight flight)
    {
        this.flight = flight;
        this.date = new Date();
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
    
}
